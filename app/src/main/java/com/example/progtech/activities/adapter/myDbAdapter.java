package com.example.progtech.activities.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.progtech.activities.model.Subject;
import com.example.progtech.activities.model.TotalNilai;

import java.util.ArrayList;
import java.util.List;

public class myDbAdapter {
    myDbHelper myhelper;
    TotalNilai totalNilai;
    private static SQLiteDatabase database;
    private static final String DATABASE_TABLE = "user";

    long nsaa1;
    long bsaa1;
    long nsaa2;
    long bsaa2;
    long nsaa3;
    long bsaa3;
    long nsaa4;
    long bsaa4;
    long nsaa5;
    long bsaa5;
    long gp;
    String gp2;
    long nilai;
    String nilai1;
    long estimatedscore2;

    public myDbAdapter(Context context) {
        myhelper = new myDbHelper(context);
    }



    public long insertData(String title, String note, String input_nilai_saa1, String input_bobot_saa1, String input_nilai_saa2, String input_bobot_saa2, String input_nilai_saa3, String input_bobot_saa3, String input_nilai_uts, String input_bobot_uts, String input_nilai_uas, String input_bobot_uas) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if(title == null){
            title = "0";
        }else{
            contentValues.put(myDbHelper.TITLE, title);
        }
        if(note == null){
            note = "0";
        }else {
            contentValues.put(myDbHelper.NOTE, note);
        }
        if(input_nilai_saa1 == null){
            input_nilai_saa1 = "0";
        }else {
            contentValues.put(myDbHelper.SAA1_NILAI, input_nilai_saa1);
        }
        if(input_bobot_saa1 == null){
            input_bobot_saa1 = "0";
        }else {
            contentValues.put(myDbHelper.SAA1_BOBOT, input_bobot_saa1);
        }
        if(input_nilai_saa2 == null){
            input_nilai_saa2 = "0";
        }else {
            contentValues.put(myDbHelper.SAA2_NILAI, input_nilai_saa2);
        }
        if(input_bobot_saa2 == null){
            input_bobot_saa2 = "0";
        }else {
            contentValues.put(myDbHelper.SAA2_BOBOT, input_bobot_saa2);
        }
        if(input_nilai_saa3 == null){
            input_nilai_saa3 = "0";
        }else {
            contentValues.put(myDbHelper.SAA3_NILAI, input_nilai_saa3);
        }
        if(input_bobot_saa3 == null){
            input_bobot_saa3 = "0";
        }else {
            contentValues.put(myDbHelper.SAA3_BOBOT, input_bobot_saa3);
        }
        if(input_nilai_uts == null){
            input_nilai_uts = "0";
        }else {
            contentValues.put(myDbHelper.UTS_NILAI, input_nilai_uts);
        }
        if(input_bobot_uts == null){
            input_bobot_uts = "0";
        }else {
            contentValues.put(myDbHelper.UTS_BOBOT, input_bobot_uts);
        }
        if(input_nilai_uas == null){
            input_nilai_uas = "0";
        }else {
            contentValues.put(myDbHelper.UAS_NILAI, input_nilai_uas);
        }
        if(input_bobot_uas == null){
            input_bobot_uas = "0";
        }else {
            contentValues.put(myDbHelper.UAS_BOBOT, input_bobot_uas);
        }
        contentValues.put(myDbHelper.ESTIMATED_SCORE, hitungestimate(input_nilai_saa1, input_bobot_saa1, input_nilai_saa2, input_bobot_saa2, input_nilai_saa3, input_bobot_saa3, input_nilai_uts, input_bobot_uts, input_nilai_uas, input_bobot_uas));
        contentValues.put(myDbHelper.FINAL_SCORE, hitunggrade(hitungestimate(input_nilai_saa1, input_bobot_saa1, input_nilai_saa2, input_bobot_saa2, input_nilai_saa3, input_bobot_saa3, input_nilai_uts, input_bobot_uts, input_nilai_uas, input_bobot_uas)));
        long id = dbb.insert(myDbHelper.TABLE_NAME, null, contentValues);
        return id;
    }

    public String hitungestimate(String input_nilai_saa1, String input_bobot_saa1, String input_nilai_saa2, String input_bobot_saa2, String input_nilai_saa3, String input_bobot_saa3, String input_nilai_uts, String input_bobot_uts, String input_nilai_uas, String input_bobot_uas) {
        nsaa1 = Long.parseLong(input_nilai_saa1);
        bsaa1 = Long.parseLong(input_bobot_saa1);
        nsaa2 = Long.parseLong(input_nilai_saa2);
        bsaa2 = Long.parseLong(input_bobot_saa2);
        nsaa3 = Long.parseLong(input_nilai_saa3);
        bsaa3 = Long.parseLong(input_bobot_saa3);
        nsaa4 = Long.parseLong(input_nilai_uts);
        bsaa4 = Long.parseLong(input_bobot_uts);
        nsaa5 = Long.parseLong(input_nilai_uas);
        bsaa5 = Long.parseLong(input_bobot_uas);

        nilai = 0;

        if(nsaa1 != 0 || bsaa1 != 0){
        nilai = nilai + (nsaa1 * bsaa1 / 100);
        }
        if(nsaa2 != 0 || bsaa2 != 0){
            nilai = nilai + (nsaa2 * bsaa2 / 100);
        }
        if(nsaa3 != 0 || bsaa3 != 0){
            nilai = nilai + (nsaa3 * bsaa3 / 100);
        }
        if(nsaa4 != 0 || bsaa4 != 0){
            nilai = nilai + (nsaa4 * bsaa4 / 100);
        }
        if(nsaa5 != 0 || bsaa5 != 0){
            nilai = nilai + (nsaa5 * bsaa5 / 100);
        }
         nilai1 = "" + nilai;

        return nilai1;
    }

    public long hitunggrade(String estimatedscore){
        estimatedscore2 = Long.parseLong(estimatedscore);
        if(estimatedscore2 >= 85){
            gp = 4;
        } else if(estimatedscore2 >= 80 && estimatedscore2 <= 84){
            gp = (long) 3.75;
        } else if(estimatedscore2 >= 75 && estimatedscore2 <= 75){
            gp = (long) 3.5;
        } else if(estimatedscore2 >= 70 && estimatedscore2 <= 74){
            gp = 3;
        } else if(estimatedscore2 >= 65 && estimatedscore2 <= 69){
            gp = (long) 2.75;
        } else if(estimatedscore2 >= 60 && estimatedscore2 <= 64){
            gp = (long) 2.5;
        } else if(estimatedscore2 >= 55 && estimatedscore2 <= 59){
            gp = 2;
        } else if(estimatedscore2 >= 50 && estimatedscore2 <= 54){
            gp = (long) 1.75;
        } else if(estimatedscore2 >= 40 && estimatedscore2 <= 50){
            gp = 1;
        } else{
            gp = 0;
        }
        gp2 = "" + gp;
        return gp;
    }

    public static ArrayList<Subject> getNilai() {
        ArrayList<Subject> subject = new ArrayList<>();
        Subject subject1;
        Cursor cursor = database.query(DATABASE_TABLE, null, null, null, null, null, "_ID" + "DESC", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                subject1 = new Subject();
                subject1.setNilai_saa1(cursor.getString(cursor.getColumnIndexOrThrow("saa1_nilai")));
                subject1.setBobot_saa1(cursor.getString(cursor.getColumnIndexOrThrow("saa1_bobot")));
                subject1.setNilai_saa2(cursor.getString(cursor.getColumnIndexOrThrow("saa2_nilai")));
                subject1.setBobot_saa2(cursor.getString(cursor.getColumnIndexOrThrow("saa2_bobot")));
                subject1.setNilai_saa3(cursor.getString(cursor.getColumnIndexOrThrow("saa3_nilai")));
                subject1.setBobot_saa3(cursor.getString(cursor.getColumnIndexOrThrow("saa3_bobot")));
                subject1.setNilai_uts(cursor.getString(cursor.getColumnIndexOrThrow("uts_nilai")));
                subject1.setBobot_uts(cursor.getString(cursor.getColumnIndexOrThrow("uts_bobot")));
                subject1.setNilai_uas(cursor.getString(cursor.getColumnIndexOrThrow("uas_nilai")));
                subject1.setBobot_uas(cursor.getString(cursor.getColumnIndexOrThrow("uas_bobot")));
                subject.add(subject1);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return subject;
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
                    Subject user = new Subject(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14));

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
        private static final String ESTIMATED_SCORE = "estimatedscore"; //ESTIMATED SCORE
        private static final String FINAL_SCORE = "finalscore"; //FINAL SCORE
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE + " VARCHAR(255) ," + NOTE + " TEXT, " + SAA1_NILAI + " VARCHAR(3), " + SAA1_BOBOT + " VARCHAR(3), " + SAA2_NILAI + " VARCHAR(3), " + SAA2_BOBOT + " VARCHAR(3), " + SAA3_NILAI + " VARCHAR(3), " + SAA3_BOBOT + " VARCHAR(3), " + UTS_NILAI + " VARCHAR(3), " + UTS_BOBOT + " VARCHAR(3), " + UAS_NILAI + " VARCHAR(3), " + UAS_BOBOT + " VARCHAR(3), " + ESTIMATED_SCORE + " VARCHAR(3), " + FINAL_SCORE + " VARCHAR(3) );";
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

