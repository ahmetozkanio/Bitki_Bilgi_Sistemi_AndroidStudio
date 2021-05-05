package com.example.bitki_bilgi_sistemi.Manager;

public class Meyve {
    private int id;
    private String meyvedurumu;
    private String meyveTipi;
    private String meyveBuyuklugu;
    private String meyveRengi;
    private String meyveYenilebilirligi;
    private String meyveZamani;

    public Meyve() {
    }

    public Meyve(int id, String meyvedurumu, String meyveTipi, String meyveBuyuklugu, String meyveRengi, String meyveYenilebilirligi, String meyveZamani) {
        this.id = id;
        this.meyvedurumu = meyvedurumu;
        this.meyveTipi = meyveTipi;
        this.meyveBuyuklugu = meyveBuyuklugu;
        this.meyveRengi = meyveRengi;
        this.meyveYenilebilirligi = meyveYenilebilirligi;
        this.meyveZamani = meyveZamani;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeyvedurumu() {
        return meyvedurumu;
    }

    public void setMeyvedurumu(String meyvedurumu) {
        this.meyvedurumu = meyvedurumu;
    }

    public String getMeyveTipi() {
        return meyveTipi;
    }

    public void setMeyveTipi(String meyveTipi) {
        this.meyveTipi = meyveTipi;
    }

    public String getMeyveBuyuklugu() {
        return meyveBuyuklugu;
    }

    public void setMeyveBuyuklugu(String meyveBuyuklugu) {
        this.meyveBuyuklugu = meyveBuyuklugu;
    }

    public String getMeyveRengi() {
        return meyveRengi;
    }

    public void setMeyveRengi(String meyveRengi) {
        this.meyveRengi = meyveRengi;
    }

    public String getMeyveYenilebilirligi() {
        return meyveYenilebilirligi;
    }

    public void setMeyveYenilebilirligi(String meyveYenilebilirligi) {
        this.meyveYenilebilirligi = meyveYenilebilirligi;
    }

    public String getMeyveZamani() {
        return meyveZamani;
    }

    public void setMeyveZamani(String meyveZamani) {
        this.meyveZamani = meyveZamani;
    }
}
