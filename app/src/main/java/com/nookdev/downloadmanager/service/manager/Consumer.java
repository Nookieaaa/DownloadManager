package com.nookdev.downloadmanager.service.manager;


import android.os.Environment;
import android.util.Log;

import com.nookdev.downloadmanager.database.models.Task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Consumer implements Runnable {

    int maxDownloads = 3;

    int bufferSize = 8*1024;
    Task task;

    public Consumer(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        download();
    }

    private void download(){
        try {
            URL url = new URL(task.getSource());
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoOutput(true);
            conn.connect();

            String downloadsFolderName = "nookloader";
            File downloadsFolder = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),downloadsFolderName);
            if (!downloadsFolder.exists()){
                downloadsFolder.mkdirs();
            }

            String filename = task.getFilename();

            File file = new File(downloadsFolder,filename);
            FileOutputStream fos = new FileOutputStream(file);
            InputStream fis = conn.getInputStream();
            byte[] buffer = new byte[bufferSize];
            int bufferLength = 0;
            long startTime = System.currentTimeMillis();
            int downloaded = 0;
            int originalSize = conn.getContentLength();

            while ((bufferLength=fis.read(buffer))>0){
                fos.write(buffer,0,bufferLength);
                downloaded += bufferLength;
            }
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
        Log.d("Download", "Downloading finished");
    }

}
