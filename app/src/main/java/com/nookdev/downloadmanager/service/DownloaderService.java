package com.nookdev.downloadmanager.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.nookdev.downloadmanager.service.manager.DownloadManager;
import com.nookdev.downloadmanager.service.manager.DownloadThread;

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
        registerReceiver(new TaskReceiver(),new IntentFilter(TaskReceiver.BROADCAST_ACTION_ADD));

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        DownloadThread downloadThread = new DownloadThread();
        downloadThread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
