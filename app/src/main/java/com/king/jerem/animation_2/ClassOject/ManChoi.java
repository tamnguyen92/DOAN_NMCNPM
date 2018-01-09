package com.king.jerem.animation_2.ClassOject;

/**
 * Created by jerem on 08/01/2018.
 */

public class ManChoi {
    public String Tenman;
    int dokho;
    String hinh;
    int mahinh;
    int mahinhbac;
    boolean unclock=false;
    int exp,expunclock;

    public int getMahinhbac() {
        return mahinhbac;
    }

    public void setMahinhbac(int mahinhbac) {
        this.mahinhbac = mahinhbac;
    }

    public ManChoi(String tenman, int dokho, String hinh, int mahinh, boolean unclock, int exp, int expunclock, int mahinhbac) {
        Tenman = tenman;
        this.mahinhbac=mahinhbac;
        this.dokho = dokho;
        this.hinh = hinh;
        this.mahinh = mahinh;
        this.unclock = unclock;
        this.exp = exp;
        this.expunclock = expunclock;
    }

    public int getMahinh() {
        return mahinh;
    }

    public void setMahinh(int mahinh) {
        this.mahinh = mahinh;
    }

    public ManChoi() {
    }

    public String getTenman() {
        return Tenman;
    }

    public void setTenman(String tenman) {
        Tenman = tenman;
    }

    public int getDokho() {
        return dokho;
    }

    public void setDokho(int dokho) {
        this.dokho = dokho;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public boolean isUnclock() {
        return unclock;
    }

    public void setUnclock(boolean unclock) {
        this.unclock = unclock;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExpunclock() {
        return expunclock;
    }

    public void setExpunclock(int expunclock) {
        this.expunclock = expunclock;
    }
}
