package com.example.progtech.activities.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.progtech.activities.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    myDbHelper myhelper;
    public DatabaseHelper(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String subject, String sks)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.SUBJECT, subject);
        contentValues.put(myDbHelper.SKS, sks);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public List<Subject> allPlayers() {
        List<Subject> ArrayList = new ArrayList<>();
        String selectQuery = "SELECT * FROM subject";
        SQLiteDatabase db = myhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null){

        }
        else if(cursor!=null){
            if (cursor.moveToFirst()) {
                do {
//                Log.e("title", cursor.getString(1));
                    Subject subject = new Subject(cursor.getString(1),cursor.getString(2));

                    ArrayList.add(subject);
                } while (cursor.moveToNext());
            }
        }


        db.close();
        Log.e("list", ArrayList.toString());
        return ArrayList;
    }


    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "subject";   // Table Name
        private static final int DATABASE_Version = 1;   // Database Version
        private static final String UID="_id";
        private static final String SUBJECT = "subject";
        private static final String SKS = "sks";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+SUBJECT+" VARCHAR(255) ,"+SKS+" TEXT);";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}

