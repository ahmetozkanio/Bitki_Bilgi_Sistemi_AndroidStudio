package com.example.bitki_bilgi_sistemi.Manager;

public class Yaprak {
    private int id;
    private String yaprakDokme;
    private String yaprakTipi;
    private String yaprakSekli;
    private String yaprakBuyuklugu;
    private String yaprakKokusu;
    private String yaprakDokusu;
    private String yaprakRengi;
    private String yaprakGuzRengi;
    private String yaprakNotlar;

    public Yaprak() {
    }

    public Yaprak(int id, String yaprakDokme, String yaprakTipi, String yaprakSekli, String yaprakBuyuklugu, String yaprakKokusu, String yaprakDokusu, String yaprakRengi, String yaprakGuzRengi, String yaprakNotlar) {
        this.id = id;
        this.yaprakDokme = yaprakDokme;
        this.yaprakTipi = yaprakTipi;
        this.yaprakSekli = yaprakSekli;
        this.yaprakBuyuklugu = yaprakBuyuklugu;
        this.yaprakKokusu = yaprakKokusu;
        this.yaprakDokusu = yaprakDokusu;
        this.yaprakRengi = yaprakRengi;
        this.yaprakGuzRengi = yaprakGuzRengi;
        this.yaprakNotlar = yaprakNotlar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYaprakDokme() {
        return yaprakDokme;
    }

    public void setYaprakDokme(String yaprakDokme) {
        this.yaprakDokme = yaprakDokme;
    }

    public String getYaprakTipi() {
        return yaprakTipi;
    }

    public void setYaprakTipi(String yaprakTipi) {
        this.yaprakTipi = yaprakTipi;
    }

    public String getYaprakSekli() {
        return yaprakSekli;
    }

    public void setYaprakSekli(String yaprakSekli) {
        this.yaprakSekli = yaprakSekli;
    }

    public String getYaprakBuyuklugu() {
        return yaprakBuyuklugu;
    }

    public void setYaprakBuyuklugu(String yaprakBuyuklugu) {
        this.yaprakBuyuklugu = yaprakBuyuklugu;
    }

    public String getYaprakKokusu() {
        return yaprakKokusu;
    }

    public void setYaprakKokusu(String yaprakKokusu) {
        this.yaprakKokusu = yaprakKokusu;
    }

    public String getYaprakDokusu() {
        return yaprakDokusu;
    }

    public void setYaprakDokusu(String yaprakDokusu) {
        this.yaprakDokusu = yaprakDokusu;
    }

    public String getYaprakRengi() {
        return yaprakRengi;
    }

    public void setYaprakRengi(String yaprakRengi) {
        this.yaprakRengi = yaprakRengi;
    }

    public String getYaprakGuzRengi() {
        return yaprakGuzRengi;
    }

    public void setYaprakGuzRengi(String yaprakGuzRengi) {
        this.yaprakGuzRengi = yaprakGuzRengi;
    }

    public String getYaprakNotlar() {
        return yaprakNotlar;
    }

    public void setYaprakNotlar(String yaprakNotlar) {
        this.yaprakNotlar = yaprakNotlar;
    }
}
