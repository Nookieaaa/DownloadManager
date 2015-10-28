package com.nookdev.downloadmanager.service.manager;


public class DownloadManager {
    private static DownloadManager instance = new DownloadManager();
    public static DownloadManager getInstance() {
        return instance;
    }

    private DownloadManager() {
    }
}
