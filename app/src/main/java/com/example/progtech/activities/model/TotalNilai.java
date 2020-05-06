package com.example.progtech.activities.model;

public class TotalNilai {

    private int nilai;
    private int bobot;
    private int makul;

    public TotalNilai(int nilai, int bobot, int makul) {
        this.nilai = nilai;
        this.bobot = bobot;
        this.makul = makul;
    }

    public int getNilai() {
        return nilai;
    }

    public void setNilai(int nilai) {
        this.nilai = nilai;
    }

    public int getBobot() {
        return bobot;
    }

    public void setBobot(int bobot) {
        this.bobot = bobot;
    }

    public int getMakul() {
        return makul;
    }

    public void setMakul(int makul) {
        this.makul = makul;
    }
}
