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

        /*Consumer downloadThread = new Consumer();
        downloadThread.start();*/
        if (intent.hasExtra("download")) {
            if (intent.getStringExtra("download").toString().equals("1")) {
                downloadManager = DownloadManager.getInstance();
                Task task = new Task("http://www.ex.ua/load/24014293", "file.mp4", "file.mp4", "mp4", 0, 1, 1);
                Task task2 = new Task("http://www.ex.ua/load/24014293", "file1.mp4", "file1.mp4", "mp4", 0, 1, 1);
                Task task3 = new Task("http://www.ex.ua/load/24014293", "file2.mp4", "file2.mp4", "mp4", 0, 1, 1);
                downloadManager.enqueue(task);
                downloadManager.enqueue(task2);
                downloadManager.enqueue(task3);
                downloadManager.start();
            }
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
