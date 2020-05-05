package com.example.progtech.activities.model;

public class Subject {
    private String mataKuliah, sks;

    public Subject(String matakuliah, String sks) {
        this.mataKuliah = matakuliah;
        this.sks = sks;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }
}
