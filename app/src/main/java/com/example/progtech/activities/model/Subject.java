package com.example.progtech.activities.model;

public class Subject {
    private String title, note;
    private String nilai_saa1, nilai_saa2, nilai_saa3, nilai_uts, nilai_uas;
    private String bobot_saa1, bobot_saa2, bobot_saa3, bobot_uts, bobot_uas;

    public Subject(String title, String note, String nilai_saa1, String nilai_saa2, String nilai_saa3, String nilai_uts, String nilai_uas, String bobot_saa1, String bobot_saa2, String bobot_saa3, String bobot_uts, String bobot_uas) {
        this.title = title;
        this.note = note;
        this.nilai_saa1 = nilai_saa1;
        this.nilai_saa2 = nilai_saa2;
        this.nilai_saa3 = nilai_saa3;
        this.nilai_uts = nilai_uts;
        this.nilai_uas = nilai_uas;
        this.bobot_saa1 = bobot_saa1;
        this.bobot_saa2 = bobot_saa2;
        this.bobot_saa3 = bobot_saa3;
        this.bobot_uts = bobot_uts;
        this.bobot_uas = bobot_uas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNilai_saa1() {
        return nilai_saa1;
    }

    public void setNilai_saa1(String nilai_saa1) {
        this.nilai_saa1 = nilai_saa1;
    }

    public String getNilai_saa2() {
        return nilai_saa2;
    }

    public void setNilai_saa2(String nilai_saa2) {
        this.nilai_saa2 = nilai_saa2;
    }

    public String getNilai_saa3() {
        return nilai_saa3;
    }

    public void setNilai_saa3(String nilai_saa3) {
        this.nilai_saa3 = nilai_saa3;
    }

    public String getNilai_uts() {
        return nilai_uts;
    }

    public void setNilai_uts(String nilai_uts) {
        this.nilai_uts = nilai_uts;
    }

    public String getNilai_uas() {
        return nilai_uas;
    }

    public void setNilai_uas(String nilai_uas) {
        this.nilai_uas = nilai_uas;
    }

    public String getBobot_saa1() {
        return bobot_saa1;
    }

    public void setBobot_saa1(String bobot_saa1) {
        this.bobot_saa1 = bobot_saa1;
    }

    public String getBobot_saa2() {
        return bobot_saa2;
    }

    public void setBobot_saa2(String bobot_saa2) {
        this.bobot_saa2 = bobot_saa2;
    }

    public String getBobot_saa3() {
        return bobot_saa3;
    }

    public void setBobot_saa3(String bobot_saa3) {
        this.bobot_saa3 = bobot_saa3;
    }

    public String getBobot_uts() {
        return bobot_uts;
    }

    public void setBobot_uts(String bobot_uts) {
        this.bobot_uts = bobot_uts;
    }

    public String getBobot_uas() {
        return bobot_uas;
    }

    public void setBobot_uas(String bobot_uas) {
        this.bobot_uas = bobot_uas;
    }
}
