package com.example.bitki_bilgi_sistemi.Manager;

public class Genel {
    private int id;
    private String latinName;
    private String turkishName;
    private String buyumeFormu;
    private String anavatani;
    private String yetisitigiBolge;
    private String ailesi;
    private String notlar;

    public Genel() {

    }
    public Genel(String latinName) {
        this.latinName = latinName;
    }

    public Genel(int id, String latinName, String turkishName, String buyumeFormu, String anavatani, String yetisitigiBolge, String ailesi, String notlar) {
        this.id = id;
        this.latinName = latinName;
        this.turkishName = turkishName;
        this.buyumeFormu = buyumeFormu;
        this.anavatani = anavatani;
        this.yetisitigiBolge = yetisitigiBolge;
        this.ailesi = ailesi;
        this.notlar = notlar;
    }

    public int getId() {
        return id;
    }



    public String getLatinName() {
        return latinName;
    }


    public String getTurkishName() {
        return turkishName;
    }


    public String getBuyumeFormu() {
        return buyumeFormu;
    }


    public String getAnavatani() {
        return anavatani;
    }


    public String getYetisitigiBolge() {
        return yetisitigiBolge;
    }

    public String getAilesi() {
        return ailesi;
    }

    public String getNotlar() {
        return notlar;
    }

}
