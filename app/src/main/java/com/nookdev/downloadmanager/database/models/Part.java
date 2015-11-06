package com.nookdev.downloadmanager.database.models;


import android.content.ContentValues;

import com.nookdev.downloadmanager.database.DbOpenHelper;

public class Part {
    private int id;
    private int taskId;
    private int startByte;
    private int endByte;
    private int partSize;
    private String source;
    private String output;
    private int status;

    public Part(int id, int taskId, int startByte, int endByte, int partSize, String source, String output, int status) {
        this.id = id;
        this.taskId = taskId;
        this.startByte = startByte;
        this.endByte = endByte;
        this.partSize = partSize;
        this.source = source;
        this.output = output;
        this.status = status;
    }

    public ContentValues toCV(){
        ContentValues cv = new ContentValues();
        cv.put(DbOpenHelper.ProgressDB.Columns.SOURCE,source);
        cv.put(DbOpenHelper.ProgressDB.Columns.OUTPUT,output);
        cv.put(DbOpenHelper.ProgressDB.Columns.STATUS,status);
        cv.put(DbOpenHelper.ProgressDB.Columns.PART_SIZE, partSize);
        cv.put(DbOpenHelper.ProgressDB.Columns.START_BYTE, startByte);
        cv.put(DbOpenHelper.ProgressDB.Columns.END_BYTE, endByte);

        return cv;
    }
}
