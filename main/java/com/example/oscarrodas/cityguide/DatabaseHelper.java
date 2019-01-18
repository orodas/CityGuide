package com.example.oscarrodas.cityguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "locations.db";
    private static final String TABLE_NAME = "locations";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_INTRO = "intro";
    private static final String COLUMN_IMAGE = "image";
    private static final String COLUMN_LINK = "link";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PHONE = "phone";
    public String[] data = new String[20];
    public String[] locate = new String[6];
    int count = 0;
    int count2 = 0;

    public SQLiteDatabase db;

    private static  final String TABLE_CREATE = "create table locations (id integer primary key not null, " +
            "name text not null, description text, category text not null, intro text not null, image text not null, " +
            "link text not null, address text not null, phone text)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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

    public void insertLocation(Location l){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from locations";
        Cursor cursor = db.rawQuery(query, null);
        int count3 = cursor.getCount();

        values.put(COLUMN_ID, count3);
        values.put(COLUMN_NAME , l.getName());
        values.put(COLUMN_DESCRIPTION, l.getDescription());
        values.put(COLUMN_CATEGORY, l.getCategory());
        values.put(COLUMN_INTRO, l.getIntro());
        values.put(COLUMN_IMAGE, l.getImage());
        values.put(COLUMN_LINK, l.getLink());
        values.put(COLUMN_ADDRESS, l.getAddress());
        values.put(COLUMN_PHONE, l.getPhone());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String[] searchLocation(){
        count2 = 0;
        db = this.getReadableDatabase();
        String query = "select name, image from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        if(cursor.moveToFirst()){
            do{
                data[count2] = cursor.getString(0);
                count2++;
                data[count2] = cursor.getString(1);
                count2++;
            }
            while (cursor.moveToNext());
        }
        return data;
    }

    public void searchLocation(String s){
        db = this.getReadableDatabase();
        String query = "select name, image, address, link, phone, description from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                locate[0] = cursor.getString(0);
                if (s.equals(locate[0])){
                    locate[1] = cursor.getString(1);
                    locate[2] = cursor.getString(2);
                    locate[3] = cursor.getString(3);
                    locate[4] = cursor.getString(4);
                    locate[5] = cursor.getString(5);
                }
            }
            while (!s.equals(locate[0])&& cursor.moveToNext());
        }
    }

    public int searchData(){
        count = 0;
        String i = "empty";
        db = this.getReadableDatabase();
        String query = "select name from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        if(cursor.moveToFirst()){
            do{
                i = cursor.getString(0);
                count++;
            }
            while (cursor.moveToNext());
        }
        return count;
    }

}
