package com.nookdev.downloadmanager.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.nookdev.downloadmanager.database.models.Task;
import com.nookdev.downloadmanager.service.manager.DownloadManager;

public class DownloaderService extends Service {
    private DownloadManager downloadManager;

    public DownloaderService() {
    }

    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("downloadservice", "service created");

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent.hasExtra("url")&&intent.hasExtra("filename")) {
            downloadManager = DownloadManager.getInstance();
            String url = intent.getStringExtra("url");
            String filename = intent.getStringExtra("filename");
            String filepath = intent.getStringExtra("filepath");
            Task task = new Task(url,filepath,filename,"ext",0,1,0);
            downloadManager.enqueue(task);
            downloadManager.start();
        }

        Log.d("SERVICE","starting");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
