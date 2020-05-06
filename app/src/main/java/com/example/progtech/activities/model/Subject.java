package com.example.progtech.activities.model;

public class Subject {
    private String mata, sks;

    public Subject(String mata, String sks) {
        this.mata = mata;
        this.sks = sks;
    }

    public String getMata() {
        return mata;
    }

    public void setMata(String mata) {
        this.mata = mata;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }
}
