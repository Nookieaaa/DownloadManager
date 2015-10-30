package com.nookdev.downloadmanager.service.manager;


import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadThread extends Thread {


    @Override
    public void run() {
        try {
            URL url = new URL("http://www.ex.ua/get/190307446");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.connect();

            File sdcard = Environment.getExternalStorageDirectory();

            //String filename = URLUtil.guessFileName(url.toString(),,conn.getContentType());

            File file = new File(sdcard,"test file.avi");
            FileOutputStream fos = new FileOutputStream(file);
            InputStream fis = conn.getInputStream();
            byte[] buffer = new byte[8*1024];
            int bufferLength = 0;
            double speed = 0;
            long startTime = System.currentTimeMillis();
            int downloaded = 0;
            int originalSize = conn.getContentLength();

            while ((bufferLength=fis.read(buffer))>0){
                fos.write(buffer,0,bufferLength);
                downloaded += bufferLength;
                speed = (double)((System.currentTimeMillis() - startTime)/1000)/(downloaded/1024);
                Log.d("speed",String.valueOf(speed));
            }
            Log.d("speed", "finished: in" + String.valueOf((System.currentTimeMillis() - startTime) / 1000));
            fos.flush();
            fos.close();
            fis.close();
            conn.disconnect();

            if (originalSize!=downloaded)
                throw new InvalidObjectException("invalid file size");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("Download","Downloading finished");
    }
}
