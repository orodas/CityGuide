package com.example.oscarrodas.cityguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper2 extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    public SQLiteDatabase db;
    public SQLiteDatabase db2;

    public static final String COLUMN_POINAME = "name";
   // @DatabaseField(columnName = COLUMN_POINAME) private String poiname;
    private static  final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "name text not null, email text not null, uname text not null, pass text not null)";

    public DatabaseHelper2(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME , c.getName());
        values.put(COLUMN_EMAIL , c.getEmail());
        values.put(COLUMN_UNAME , c.getUname());
        values.put(COLUMN_PASS , c.getPass());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select email, pass from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                if(a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    public boolean searchUname(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a = "empty";
        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                if(a.equals(uname))
                {
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return a.equals(uname);
    }

    public boolean searchEmail(String email)
    {
        db = this.getReadableDatabase();
        String query = "select email from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a = "empty";
        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                if(a.equals(email))
                {
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return a.equals(email);
    }

    public String searchName(String email)
    {
        db = this.getReadableDatabase();
        String query = "select email, uname from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a, b;
        b = "not found";

        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                if(a.equals(email))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    public String searchUsr(String usr)
    {
        db = this.getReadableDatabase();
        String query = "select uname from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a, b;
        b = "not found";

        if(cursor.moveToFirst())
        {
            do {
                a = cursor.getString(0);
                if(a.equals(usr))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }


}
