package com.vanjiii.faceme.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Class responsible to keep the DB up-to date.
 *
 * Created by vanjiii on 4/9/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static String LOG_TAG = "Database";
    public static String TABLE_PICTURES = "pictures";
    private static String DATABASE_NAME = "pictures.db";
    private static int DATABASE_VERSION = 1;

    public static String COLUMN_ID = "id";
    public static String COLUMN_PICTURE_URI = "picture_uri";
    public static String COLUMN_PERSON_NAME = "person_name";
    public static String COLUMN_PERSON_AGE = "person_age";
    public static String COLUMN_PERSON_SEX = "person_sex";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Called when the database is created for the FIRST time.
     * If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG, "Creating the database...");

        String createTableStatement = "CREATE TABLE " + TABLE_PICTURES +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + // Define a primary key
                COLUMN_PICTURE_URI + " TEXT NOT NULL, " +
                COLUMN_PERSON_NAME + " TEXT, " + // Define a foreign key
                COLUMN_PERSON_AGE + " INT, " +
                COLUMN_PERSON_SEX + " TEXT, " +
                ")";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(LOG_TAG, "Upgrading the database from version " + oldVersion + " to version " + newVersion + ", which " +
                "will destroy all old data.");

        // Simplest implementation is to drop all old tables and recreate them
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PICTURES);
        onCreate(db);
    }
}