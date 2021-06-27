package com.health.test.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.health.test.utils.Constants;

import java.io.IOException;

public class DbManager {
    /**
     * Singleton object of DbManager
     */
    private static DbManager dbManager = null;
    private Context context;
    private static DbHelper dbHelper;
    private static DbHelper2 dbHelper2;
    private static MyDbHelper myDbHelper;
    private SQLiteDatabase myDatabase, myDatabase2, myDatabaseHelper;

    private DbManager(Context context) {
        this.context = context;
    }

    /**
     * Method to create the instance for the {@link DbManager} class. This
     * method should be called before the getInstance() method
     *
     * @param context Application context
     */
    public static void createInstance(Context context) throws IOException {
        dbManager = new DbManager(context);
        dbHelper = new DbHelper(context);
        dbHelper2 = new DbHelper2(context);
        myDbHelper = new MyDbHelper(context);
    }

    /**
     * Method to get the singleton object of the {@link DbManager} class
     *
     * @return object of the {@link DbManager} class
     * @throws IllegalStateException if this method is called before calling the createInstance()
     *                               method.
     */
    public static DbManager getInstance() {
        // return dbManager;
        if (dbManager != null)
            return dbManager;
        else
            return null;
    }

    public void open() throws SQLException {
        myDatabase = dbHelper.getWritableDatabase();
        myDatabase2 = dbHelper2.getWritableDatabase();
        myDatabaseHelper = myDbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    /**
     * This method is used for inserting values in the database table
     *
     * @param values :contains values to be inserted in the table
     * @return boolean value true if values are inserted correctly else return
     * false
     */

    public long insertRows(ContentValues values, String tableName) {
        long val = myDatabase.insert(tableName, null, values);
        return val;
    }

    public long insertRowsInDb(ContentValues values, String tableName) {
        long val = myDatabaseHelper.insert(tableName, null, values);
        return val;
    }

    /**
     * This method is used for updating values in the database table
     *
     * @param values :contains values to be inserted in the table
     * @return boolean value true if values are inserted correctly else return
     * false
     */

    public int updteRows(String tableName, ContentValues values,
                         String whereClause) {
        int val = myDatabase.update(tableName, values, whereClause, null);
        return val;
    }

    /**
     * This method is used to get the values from the database Table
     *
     * @return the cursor on the result of the query
     */

    public Cursor getAllValues(String tableName) {
        Cursor myResult;
        myResult = myDatabase.query(tableName, null, null, null, null, null,
                null, null);
        return myResult;
    }

    public Cursor selectQuery(String query) throws SQLException {
        Cursor mCursor = myDatabase.rawQuery(query, null);
        mCursor.moveToFirst();
        return mCursor;
    }

    public Cursor mySelectQuery(String query) throws SQLException {
        Cursor mCursor = myDatabaseHelper.rawQuery(query, null);
        mCursor.moveToFirst();
        return mCursor;
    }

    public Cursor selectQuery2(String query) throws SQLException {
        Cursor mCursor = myDatabase2.rawQuery(query, null);
        mCursor.moveToFirst();
        return mCursor;
    }

    public void DeleteCases(String query) {
        myDatabase.execSQL(query);
    }

    /**
     * This method is used to get the values from the database Table
     *
     * @return the cursor on the result of the query
     */

    public Cursor getAllottedCases(String tableName, String userName) {
        Cursor myResult;
        String selectionArgs[] = {userName};
        myResult = myDatabase.query(tableName, null, Constants.LOGIN_ID + "=?",
                selectionArgs, null, null, null, null);
        return myResult;
    }

    /**
     * Checks whether database tables has been created
     *
     * @param tablename name of the table to check if created
     * @return Returns true if opened else returns false
     */
    public boolean checkIfDataBasePresent(String tablename) {
        int count = 0;
        try {
            Cursor cursor = getAllValues(tablename);
            count = cursor.getCount();
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (count > 0)
            return true;
        else
            return false;
    }

    public void add_tbl_Notification(String tableName,
                                     String heading, String detail,
                                     String category, String keywords, String datetime) {
        ContentValues data = new ContentValues();
        data.put(Constants.heading, heading);
        data.put(Constants.detail, detail);
        data.put(Constants.category, category);
        data.put(Constants.keywords, keywords);
        data.put(Constants.date_time, datetime);
        insertRowsInDb(data, tableName);
    }

}
