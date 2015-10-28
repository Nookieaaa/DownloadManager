package com.nookdev.downloadmanager.database.models;


import android.content.ContentValues;

import com.nookdev.downloadmanager.database.DbOpenHelper;

import java.util.List;

public class Task {
    private int id;
    private String filename;
    private String source;
    private String output;
    private String extension;
    private int size;
    private int parts_count;
    private int status;
    List<Part> parts;

    public Task(int id, String source, String output,String filename, String extension, int size, int parts_count, int status) {
        this.id = id;
        this.filename = filename;
        this.source = source;
        this.output = output;
        this.extension = extension;
        this.size = size;
        this.parts_count = parts_count;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task( String source, String output,String filename, String extension, int size, int parts_count, int status) {
        this.id = -1;
        this.source = source;
        this.filename = filename;
        this.output = output;
        this.extension = extension;
        this.size = size;
        this.parts_count = parts_count;
        this.status = status;
    }

    public ContentValues toCV(){
        ContentValues cv = new ContentValues();
        //cv.put(BaseColumns._ID,id);
        cv.put(DbOpenHelper.TasksDB.Columns.SOURCE,source);
        cv.put(DbOpenHelper.TasksDB.Columns.FILENAME,filename);
        cv.put(DbOpenHelper.TasksDB.Columns.OUTPUT,output);
        cv.put(DbOpenHelper.TasksDB.Columns.EXTENSION, extension);
        cv.put(DbOpenHelper.TasksDB.Columns.INITIAL_SIZE,size);
        cv.put(DbOpenHelper.TasksDB.Columns.PARTS_COUNT,parts_count);
        cv.put(DbOpenHelper.TasksDB.Columns.STATUS,status);

        return cv;
    }

}
