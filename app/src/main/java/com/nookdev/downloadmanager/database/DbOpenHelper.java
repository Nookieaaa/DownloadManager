package com.nookdev.downloadmanager.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbOpenHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "downloads.db";

    //db for keeping tasks
    public static class TasksDB{

        public static final String TABLE_NAME = "tasks";
        public static class Columns{
            public static final String ID = "_ID";
            public static final String SOURCE = "source";
            public static final String OUTPUT = "output";
            public static final String INITIAL_SIZE = "size";
            public static final String PARTS = "parts";
            public static final String STATUS = "status";
            public static final String FILENAME = "filename";
            public static final String EXTENSION = "extension";
            public static final String PARTS_COUNT = "parts_count";
        }

    }

    //db for keeping progress for each task
    public static class ProgressDB{
        public static final String TABLE_NAME = "progress";
        public static final String CREATE_DB_SCRIPT = "";

        public static class Columns{
            public static final String ID = "_ID";
            public static final String TASK_ID = "task_id";
            public static final String START_BYTE = "start_byte";
            public static final String END_BYTE = "end_byte";
            public static final String PART_SIZE = "part_size";
            public static final String SOURCE = "source";
            public static final String OUTPUT = "output";
            public static final String STATUS = "status";
        }

    }


    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
