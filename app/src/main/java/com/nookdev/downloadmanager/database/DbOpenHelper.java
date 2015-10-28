package com.nookdev.downloadmanager.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DbOpenHelper extends SQLiteOpenHelper implements BaseColumns {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "downloads.db";

    //db for keeping tasks
    public static class TasksDB{

        public static final String TABLE_NAME = "tasks";
        public static final String CREATE_DB_SCRIPT = "create table " + TABLE_NAME +
                " ( " +
                BaseColumns._ID + " integer primary key autoincrement, "+
                Columns.FILENAME + " text not null, " +
                Columns.EXTENSION + " text not null, " +
                Columns.OUTPUT + " text not null, " +
                Columns.SOURCE + " text not null, " +
                Columns.INITIAL_SIZE + " integer not null, " +
                Columns.STATUS + " integer not null, " +
                Columns.PARTS_COUNT + " integer not null "
                + " ) ";


        public static class Columns{
            public static final String SOURCE = "source";
            public static final String OUTPUT = "output";
            public static final String INITIAL_SIZE = "size";
            public static final String STATUS = "status";
            public static final String FILENAME = "filename";
            public static final String EXTENSION = "extension";
            public static final String PARTS_COUNT = "parts_count";
        }

    }

    //db for keeping progress for each task
    public static class ProgressDB{
        public static final String TABLE_NAME = "progress";
        public static final String CREATE_DB_SCRIPT = "create table " + TABLE_NAME +
                " ( " +
                BaseColumns._ID + " integer primary key autoincrement, "+
                Columns.OUTPUT + " text not null, " +
                Columns.SOURCE + " text not null, " +
                Columns.PART_SIZE + " integer not null, " +
                Columns.START_BYTE + " integer not null, " +
                Columns.END_BYTE + " integer not null, " +
                Columns.STATUS + " integer not null, " +
                Columns.TASK_ID + " integer not null, " +
                "foreign key ("+ Columns.TASK_ID + ") references "
                    + TasksDB.TABLE_NAME + " ( " + BaseColumns._ID + " )"
                + " ) ";

        public static class Columns{
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
        createTasksDb(db);
        createProgressDb(db);
    }

    private void createProgressDb(SQLiteDatabase db) {
        db.execSQL(ProgressDB.CREATE_DB_SCRIPT);
    }

    private void createTasksDb(SQLiteDatabase db) {
        db.execSQL(TasksDB.CREATE_DB_SCRIPT);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
