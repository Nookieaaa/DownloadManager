package com.nookdev.downloadmanager.views.model;


import android.net.Uri;

import java.util.Date;

public class DownloadItemModel {
    private Uri downloadLink;
    private long id;
    private String filename;
    private Date addedAt;
    private Uri fileLocation;
    private int state;
    private int progress;
    private double speed;
    private double maxSpeed;
    private int connectionType;

    //download states
    public static final int DOWNLOAD_STATE_ERROR = 0;
    public static final int DOWNLOAD_STATE_ADDED =1;
    public static final int DOWNLOAD_STATE_IN_QUEUE = 2;
    public static final int DOWNLOAD_STATE_PAUSED = 3;
    public static final int DOWNLOAD_STATE_DOWNLOADING = 4;
    public static final int DOWNLOAD_STATE_WAITING_FOR_CONNECTION = 5;
    public static final int DOWNLOAD_STATE_FINISHED = 6;

    //connection types
    public static final int CONNECTION_TYPE_WIFI = 1;
    public static final int CONNECTION_TYPE_MOBILE = 2;


    public enum DOWNLOAD_STATES {ADDED,IN_QUEUE,PAUSED,DOWNLOADING,
        ERROR,DOWNLOAD_STATE_WAITING_FOR_CONNECTION,FINISHED};

    public DownloadItemModel(Uri downloadLink) {
        this.downloadLink = downloadLink;
    }

    public DownloadItemModel(int progress, String filename) {
        this.progress = progress;
        this.filename = filename;
    }

    public String getState() {
        //TODO change state
        return "Added";
    }

    public String getFilename() {
        return filename;
    }

    public int getProgress() {
        return progress;
    }
}
