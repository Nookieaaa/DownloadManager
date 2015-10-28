package com.nookdev.downloadmanager.database;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.nookdev.downloadmanager.App;
import com.nookdev.downloadmanager.database.models.Task;

public class DatabaseController {
    DbOpenHelper dbOpenHelper;

    public DatabaseController() {
        dbOpenHelper = new DbOpenHelper(App.getAppContext());
    }

    public int add(Task task){
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        String taskTableName = DbOpenHelper.TasksDB.TABLE_NAME;
        ContentValues taskCV = task.toCV();
        int id = (int)db.insert(taskTableName,null,taskCV);

        Log.d("sqlite", "inserted " + taskCV.toString());
        Log.d("sqlite","id: "+id);

        task.setId(id);

        db.close();
        return id;
    }

    public boolean update(Task task){
        boolean result = false;
        return result;
    }

    public boolean delete(Task task){
        boolean result = false;
        return result;
    }
}
