package com.health.test.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import com.health.test.BuildConfig;
import com.health.test.utils.Constants;
import com.health.test.utils.IConstants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.health.test.utils.Constants.PDF_FOLDER_NAME;

public class DbHelper2 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME_1 = "quotes.db";
    private static final String dbFolderPath = Environment.getExternalStorageDirectory() + File.separator + IConstants.MAKE_FOLDER + File.separator + PDF_FOLDER_NAME + File.separator;
    private static final String dbFolderPath1 = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/";

    private Context mycontext;
    private static String DB_NAME = "shrihari_db.sqlite";
    private static String DB_PATH = "/data/data/" + BuildConfig.APPLICATION_ID + "/databases/";
    public SQLiteDatabase myDataBase;

    public DbHelper2(Context context) throws IOException {
        //super(context, DATABASE_NAME, null, Constants.DB_VERSION);
        super(context, dbFolderPath + "/" + DATABASE_NAME_1, null, Constants.DB_VERSION);
        //super(context,DB_NAME,null,1);
        /*this.mycontext=context;
        boolean dbexist = checkdatabase();
        if (dbexist) {
            System.out.println("Database exists");
            opendatabase();
        } else {
            System.out.println("Database doesn't exist");
            createdatabase();
        }*/
    }

    public void createdatabase() throws IOException {
        boolean dbexist = checkdatabase();
        if (dbexist) {
            System.out.println(" Database exists.");
        } else {
            this.getReadableDatabase();
            try {
                copydatabase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkdatabase() {

        boolean checkdb = false;
        try {
            String myPath = DB_PATH + DB_NAME;
            File dbfile = new File(myPath);
            checkdb = dbfile.exists();
        } catch (SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkdb;
    }

    private void copydatabase() throws IOException {
        //Open your local db as the input stream
        InputStream myinput = mycontext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outfilename = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myoutput = new FileOutputStream(outfilename);

        // transfer byte to inputfile to outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myinput.read(buffer)) > 0) {
            myoutput.write(buffer, 0, length);
        }

        //Close the streams
        myoutput.flush();
        myoutput.close();
        myinput.close();
    }

    public void opendatabase() throws SQLException {
        //Open the database
        String mypath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close() {
        if (myDataBase != null) {
            myDataBase.close();
        }
        super.close();
    }

    private static final String DATABASE_CREATE_tbl_Notification = " create table "
            + Constants.tbl_Notification
            + "("
            + Constants.idt
            + " INTEGER PRIMARY KEY AUTOINCREMENT not null,"
            + Constants.NotificationText
            + " text,"
            + Constants.NotificationDate
            + " text,"
            + Constants.NotificationDesc
            + " text);";


    /**
     * this method is called when the database is created first time
     */
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE_tbl_Notification);
    }

    /**
     * this method is called when the database version is changed
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DbHelper2.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + Constants.tbl_Notification);
        onCreate(db);
    }

}
