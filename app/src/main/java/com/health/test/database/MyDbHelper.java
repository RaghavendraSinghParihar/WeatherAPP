package com.health.test.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.health.test.utils.Constants;

public class MyDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "health.db";
    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, Constants.DB_VERSION);
    }
    private static final String DATABASE_CREATE_tbl_Notification = " create table "
            + Constants.tbl_my_Notification
            + "("
            + Constants.idt
            + " INTEGER PRIMARY KEY AUTOINCREMENT not null,"
            + Constants.heading
            + " text,"
            + Constants.detail
            + " text,"
            + Constants.category
            + " text,"
            + Constants.keywords
            + " text,"
            + Constants.date_time
            + " text);";


    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_tbl_Notification);
    }

    /**
     * this method is called when the database version is changed
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbHelper.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + Constants.tbl_my_Notification);
        onCreate(db);
    }

}
