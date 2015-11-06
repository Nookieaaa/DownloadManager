package com.nookdev.downloadmanager.database.models;


import android.content.ContentValues;
import android.database.Cursor;

import com.nookdev.downloadmanager.database.DbOpenHelper;

import java.util.List;

public class Task{
    private int id;
    private String filename;
    private String source;
    private String output;
    private String extension;
    private int size;
    private int partsCount;
    private int status;

    List<Part> parts;

    public Task(int id, String source, String output,String filename, String extension, int size, int partsCount, int status) {
        this.id = id;
        this.filename = filename;
        this.source = source;
        this.output = output;
        this.extension = extension;
        this.size = size;
        this.partsCount = partsCount;
        this.status = status;
    }

    public Task(Cursor c) {
        String[] columnNames = c.getColumnNames();
        for (String col:columnNames){
            switch (col){
                case DbOpenHelper.TasksDB.Columns.FILENAME:{
                    this.filename = c.getString(c.getColumnIndex(col));
                    break;
                }
                case DbOpenHelper.TasksDB.Columns.OUTPUT:{
                    this.output = c.getString(c.getColumnIndex(col));
                    break;
                }
                case DbOpenHelper.TasksDB.Columns.EXTENSION:{
                    this.extension = c.getString(c.getColumnIndex(col));
                    break;
                }
                case DbOpenHelper.TasksDB.Columns.SOURCE:{
                    this.source = c.getString(c.getColumnIndex(col));
                    break;
                }
                case DbOpenHelper.TasksDB.Columns.STATUS:{
                    this.status = c.getInt(c.getColumnIndex(col));
                    break;
                }
                case DbOpenHelper.TasksDB.Columns.INITIAL_SIZE:{
                    this.size = c.getInt(c.getColumnIndex(col));
                    break;
                }
            }
        }
    }

    public Task(String source, String filename){
        this.source = source;
        this.filename = filename;

        this.output = filename;
        this.extension = "avi";
        this.size = 150;
        this.partsCount = 1;
        this.status = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task( String source, String output,String filename, String extension, int size, int partsCount, int status) {
        this.id = -1;
        this.source = source;
        this.filename = filename;
        this.output = output;
        this.extension = extension;
        this.size = size;
        this.partsCount = partsCount;
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
        cv.put(DbOpenHelper.TasksDB.Columns.PARTS_COUNT, partsCount);
        cv.put(DbOpenHelper.TasksDB.Columns.STATUS,status);

        return cv;
    }

    public int getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getSource() {
        return source;
    }

    public String getOutput() {
        return output;
    }

    public String getExtension() {
        return extension;
    }

    public int getSize() {
        return size;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public int getStatus() {
        return status;
    }

}
