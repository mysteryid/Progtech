package com.example.progtech.activities.model;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.progtech.activities.adapter.myDbAdapter;

import java.util.ArrayList;

public class TotalNilai {

    private String matakul;
    private String Nilai;
    private String Bobot;

    public TotalNilai() {
    }

    public String getMatakul() {
        return matakul;
    }

    public void setMatakul(String matakul) {
        this.matakul = matakul;
    }

    public String getNilai() {
        return Nilai;
    }

    public void setNilai(String nilai) {
        Nilai = nilai;
    }

    public String getBobot() {
        return Bobot;
    }

    public void setBobot(String bobot) {
        Bobot = bobot;
    }
}
