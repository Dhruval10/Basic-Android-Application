package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import Database.model.Info;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "info_db";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * onCreate() will be called only once when the app is installed.
     * In this method, we execute the create table sql statements to create necessary tables.
     */
    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create notes table
        db.execSQL(Info.CREATE_TABLE);
    }

    /**
     * onUpgrade() called when an update is released.
     */
    //Upgrading Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Info.TABLE_NAME);

        // Create tables again
        onCreate(db);

    }

    public long insertInfo(String id, String name, String sem, String branch) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(Info.COLUMN_ID, id);
        values.put(Info.COLUMN_NAME, name);
        values.put(Info.COLUMN_SEM, sem);
        values.put(Info.COLUMN_BRANCH, branch);


        // insert row
        long idd = db.insert(Info.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return idd;
    }

    public Info getInfo(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        //db.execSQL( "Select * from Information where id='15IT127'" );

        String[] projection={
                Info.COLUMN_ID,
                Info.COLUMN_NAME,
                Info.COLUMN_SEM,
                Info.COLUMN_BRANCH
        };

        String selection = Info.COLUMN_ID + " = '15IT127'";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = db.query(
                Info.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                null               // The sort order
        );

        if (cursor != null)
            cursor.moveToFirst();

        Info record = new Info(
                cursor.getString(cursor.getColumnIndex(Info.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Info.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(Info.COLUMN_SEM)),
                cursor.getString(cursor.getColumnIndex(Info.COLUMN_BRANCH)));

        return record;
    }



}
