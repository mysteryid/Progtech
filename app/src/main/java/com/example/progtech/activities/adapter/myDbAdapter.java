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

public class myDbAdapter {
    myDbHelper myhelper;

    public myDbAdapter(Context context) {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String title, String note, String input_nilai_saa1, String input_bobot_saa1, String input_nilai_saa2, String input_bobot_saa2, String input_nilai_saa3, String input_bobot_saa3, String input_nilai_uts, String input_bobot_uts, String input_nilai_uas, String input_bobot_uas) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.TITLE, title);
        contentValues.put(myDbHelper.NOTE, note);
        contentValues.put(myDbHelper.NOTE, note);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null, contentValues);
        return id;
    }

//

    public List<Subject> allPlayers() {
        List<Subject> users = new ArrayList<>();
        String selectQuery = "SELECT * FROM user";
        SQLiteDatabase db = myhelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor == null) {

        } else if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
//                Log.e("title", cursor.getString(1));
                    Subject user = new Subject(cursor.getString(1), cursor.getString(2),cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12));

                    users.add(user);
                } while (cursor.moveToNext());
            }
        }


        db.close();
        Log.e("list", users.toString());
        return users;
    }


    static class myDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String TABLE_NAME = "user";   // Table Name
        private static final int DATABASE_Version = 1;   // Database Version
        private static final String UID = "_id";
        private static final String TITLE = "title"; //Mata kuliah
        private static final String NOTE = "note"; //SKS
        private static final String SAA1_NILAI = "saa1"; //NILAI SAA 1
        private static final String SAA1_BOBOT = "bobotsaa1"; //BOBOT SAA 1
        private static final String SAA2_NILAI = "saa2"; //NILAI SAA 2
        private static final String SAA2_BOBOT = "bobotsaa2"; //BOBOT SAA 2
        private static final String SAA3_NILAI = "saa3"; //NILAI SAA 3
        private static final String SAA3_BOBOT = "bobotsaa3"; //BOBOT SAA 3
        private static final String UTS_NILAI = "uts"; //NILAI UTS
        private static final String UTS_BOBOT = "bobotuts"; //BOBOT UTS
        private static final String UAS_NILAI = "uas"; //NILAI UAS
        private static final String UAS_BOBOT = "bobotuas"; //BOBOT UAS
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE + " VARCHAR(255) ," + NOTE + " TEXT, " + SAA1_NILAI + " VARCHAR(3), " + SAA1_BOBOT + " VARCHAR(3), " + SAA2_NILAI + " VARCHAR(3), " + SAA2_BOBOT + " VARCHAR(3), " + SAA3_NILAI + " VARCHAR(3), " + SAA3_BOBOT + " VARCHAR(3), " + UTS_NILAI + " VARCHAR(3), " + UTS_BOBOT + " VARCHAR(3), " + UAS_NILAI + " VARCHAR(3), " + UAS_BOBOT + " VARCHAR(3) );";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
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

