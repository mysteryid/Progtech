package com.example.progtech.activities.model;

public class Subject {
    private String title, note;
    private String nilai_saa1, nilai_saa2, nilai_saa3, nilai_uts, nilai_uas, bobot_saa1, bobot_saa2, bobot_saa3, bobot_uts, bobot_uas;
    private String estimated, finalscore;

    double nsaa1, nsaa2, nsaa3, nuts, nuas, bsaa1, bsaa2, bsaa3, buts, buas, estim;
    double score85sementara = 0, score80sementara = 0, score75sementara = 0, score70sementara = 0, nbm = 0;
    String score85 = "", score80 = "", score75 = "", score70 = "";

    public Subject(String title, String note, String nilai_saa1, String nilai_saa2, String nilai_saa3, String nilai_uts, String nilai_uas, String bobot_saa1, String bobot_saa2, String bobot_saa3, String bobot_uts, String bobot_uas, String estimated, String finalscore) {
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
        this.estimated = estimated;
        this.finalscore = finalscore;
    }

    public Subject() {

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

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    public String getFinalscore() {
        return finalscore;
    }

    public void setFinalscore(String finalscore) {
        this.finalscore = finalscore;
    }

    public String getScore85() {
        nsaa1 = Double.parseDouble(getNilai_saa1());
        bsaa1 = Double.parseDouble(getBobot_saa1());
        nsaa2 = Double.parseDouble(getNilai_saa2());
        bsaa2 = Double.parseDouble(getBobot_saa2());
        nsaa3 = Double.parseDouble(getNilai_saa3());
        bsaa3 = Double.parseDouble(getBobot_saa3());
        nuts = Double.parseDouble(getNilai_uts());
        buts = Double.parseDouble(getBobot_uts());
        nuas = Double.parseDouble(getNilai_uas());
        buas = Double.parseDouble(getBobot_uas());
        estim = Double.parseDouble(getEstimated());

        Double nsaa1fix = nsaa1;
        Double bsaa1fix = nsaa2;
        Double nsaa2fix = nsaa3;
        Double bsaa2fix = nuts;
        Double nsaa3fix = nuas;
        Double bsaa3fix = bsaa1;
        Double nutsfix = bsaa2;
        Double butsfix = bsaa3;
        Double nuasfix = buts;
        Double buasfix = buas;

        nbm = 0;
        if (nsaa1fix == 0) {
            nbm = nbm + (double) bsaa1fix;
        }
        if (nsaa2fix == 0) {
            nbm = nbm + (double) bsaa2fix;
        }
        if (nsaa3fix == 0) {
            nbm = nbm + (double) bsaa3fix;
        }
        if (nutsfix == 0) {
            nbm = nbm + (double) butsfix;
        }
        if (nuasfix == 0) {
            nbm = nbm + (double) buasfix;
        }

        score85sementara = (double) (85 - (int) estim) / (double) (nbm / 100);
        score85 = "" + score85sementara;

        return score85;
    }

    public String getScore80() {
        nsaa1 = Double.parseDouble(getNilai_saa1());
        bsaa1 = Double.parseDouble(getBobot_saa1());
        nsaa2 = Double.parseDouble(getNilai_saa2());
        bsaa2 = Double.parseDouble(getBobot_saa2());
        nsaa3 = Double.parseDouble(getNilai_saa3());
        bsaa3 = Double.parseDouble(getBobot_saa3());
        nuts = Double.parseDouble(getNilai_uts());
        buts = Double.parseDouble(getBobot_uts());
        nuas = Double.parseDouble(getNilai_uas());
        buas = Double.parseDouble(getBobot_uas());
        estim = Double.parseDouble(getEstimated());

        Double nsaa1fix = nsaa1;
        Double bsaa1fix = nsaa2;
        Double nsaa2fix = nsaa3;
        Double bsaa2fix = nuts;
        Double nsaa3fix = nuas;
        Double bsaa3fix = bsaa1;
        Double nutsfix = bsaa2;
        Double butsfix = bsaa3;
        Double nuasfix = buts;
        Double buasfix = buas;

        nbm = 0;
        if (nsaa1fix == 0) {
            nbm = nbm + (double) bsaa1fix;
        }
        if (nsaa2fix == 0) {
            nbm = nbm + (double) bsaa2fix;
        }
        if (nsaa3fix == 0) {
            nbm = nbm + (double) bsaa3fix;
        }
        if (nutsfix == 0) {
            nbm = nbm + (double) butsfix;
        }
        if (nuasfix == 0) {
            nbm = nbm + (double) buasfix;
        }

        score80sementara = (double) (80 - (int) estim) / (double) (nbm / 100);
        score80 = "" + score80sementara;

        return score80;
    }

    public String getScore75() {
        nsaa1 = Double.parseDouble(getNilai_saa1());
        bsaa1 = Double.parseDouble(getBobot_saa1());
        nsaa2 = Double.parseDouble(getNilai_saa2());
        bsaa2 = Double.parseDouble(getBobot_saa2());
        nsaa3 = Double.parseDouble(getNilai_saa3());
        bsaa3 = Double.parseDouble(getBobot_saa3());
        nuts = Double.parseDouble(getNilai_uts());
        buts = Double.parseDouble(getBobot_uts());
        nuas = Double.parseDouble(getNilai_uas());
        buas = Double.parseDouble(getBobot_uas());
        estim = Double.parseDouble(getEstimated());

        Double nsaa1fix = nsaa1;
        Double bsaa1fix = nsaa2;
        Double nsaa2fix = nsaa3;
        Double bsaa2fix = nuts;
        Double nsaa3fix = nuas;
        Double bsaa3fix = bsaa1;
        Double nutsfix = bsaa2;
        Double butsfix = bsaa3;
        Double nuasfix = buts;
        Double buasfix = buas;

        nbm = 0;
        if (nsaa1fix == 0) {
            nbm = nbm + (double) bsaa1fix;
        }
        if (nsaa2fix == 0) {
            nbm = nbm + (double) bsaa2fix;
        }
        if (nsaa3fix == 0) {
            nbm = nbm + (double) bsaa3fix;
        }
        if (nutsfix == 0) {
            nbm = nbm + (double) butsfix;
        }
        if (nuasfix == 0) {
            nbm = nbm + (double) buasfix;
        }

        score75sementara = (double) (75 - (int) estim) / (double) (nbm / 100);
        score75 = "" + score75sementara;

        return score75;
    }

    public String getScore70() {
        nsaa1 = Double.parseDouble(getNilai_saa1());
        bsaa1 = Double.parseDouble(getBobot_saa1());
        nsaa2 = Double.parseDouble(getNilai_saa2());
        bsaa2 = Double.parseDouble(getBobot_saa2());
        nsaa3 = Double.parseDouble(getNilai_saa3());
        bsaa3 = Double.parseDouble(getBobot_saa3());
        nuts = Double.parseDouble(getNilai_uts());
        buts = Double.parseDouble(getBobot_uts());
        nuas = Double.parseDouble(getNilai_uas());
        buas = Double.parseDouble(getBobot_uas());
        estim = Double.parseDouble(getEstimated());

        Double nsaa1fix = nsaa1;
        Double bsaa1fix = nsaa2;
        Double nsaa2fix = nsaa3;
        Double bsaa2fix = nuts;
        Double nsaa3fix = nuas;
        Double bsaa3fix = bsaa1;
        Double nutsfix = bsaa2;
        Double butsfix = bsaa3;
        Double nuasfix = buts;
        Double buasfix = buas;

        nbm = 0;
        if (nsaa1fix == 0) {
            nbm = nbm + (double) bsaa1fix;
        }
        if (nsaa2fix == 0) {
            nbm = nbm + (double) bsaa2fix;
        }
        if (nsaa3fix == 0) {
            nbm = nbm + (double) bsaa3fix;
        }
        if (nutsfix == 0) {
            nbm = nbm + (double) butsfix;
        }
        if (nuasfix == 0) {
            nbm = nbm + (double) buasfix;
        }

        score70sementara = (double) (70 - (int) estim) / (double) (nbm / 100);
        score70 = "" + score70sementara;

        return score70;
    }
}
