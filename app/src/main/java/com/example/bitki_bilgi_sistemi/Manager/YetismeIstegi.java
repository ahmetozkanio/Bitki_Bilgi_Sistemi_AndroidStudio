package com.example.bitki_bilgi_sistemi.Manager;

public class YetismeIstegi {
    private int id;
    private String gunIsigiIstegi;
    private String suIstegi;
    private String besinGereksimi;
    private String toprakIstegi;
    private String toprakDrenaji;

    public YetismeIstegi() {
    }

    public YetismeIstegi(int id, String gunIsigiIstegi, String suIstegi, String besinGereksimi, String toprakIstegi, String toprakDrenaji) {
        this.id = id;
        this.gunIsigiIstegi = gunIsigiIstegi;
        this.suIstegi = suIstegi;
        this.besinGereksimi = besinGereksimi;
        this.toprakIstegi = toprakIstegi;
        this.toprakDrenaji = toprakDrenaji;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGunIsigiIstegi() {
        return gunIsigiIstegi;
    }

    public void setGunIsigiIstegi(String gunIsigiIstegi) {
        this.gunIsigiIstegi = gunIsigiIstegi;
    }

    public String getSuIstegi() {
        return suIstegi;
    }

    public void setSuIstegi(String suIstegi) {
        this.suIstegi = suIstegi;
    }

    public String getBesinGereksimi() {
        return besinGereksimi;
    }

    public void setBesinGereksimi(String besinGereksimi) {
        this.besinGereksimi = besinGereksimi;
    }

    public String getToprakIstegi() {
        return toprakIstegi;
    }

    public void setToprakIstegi(String toprakIstegi) {
        this.toprakIstegi = toprakIstegi;
    }

    public String getToprakDrenaji() {
        return toprakDrenaji;
    }

    public void setToprakDrenaji(String toprakDrenaji) {
        this.toprakDrenaji = toprakDrenaji;
    }
}
