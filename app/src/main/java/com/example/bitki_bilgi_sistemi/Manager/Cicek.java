package com.example.bitki_bilgi_sistemi.Manager;

public class Cicek {
    private int id;
    private String cicekDurumu;
    private String cicekBuyuklugu;
    private String cicekKokusu;
    private String cicekRengi;
    private String ciceklenmeZamani;
    private String cicekNotlar;

    public Cicek() {
    }

    public Cicek(int id, String cicekDurumu, String cicekBuyuklugu, String cicekKokusu, String cicekRengi, String ciceklenmeZamani, String cicekNotlar) {
        this.id = id;
        this.cicekDurumu = cicekDurumu;
        this.cicekBuyuklugu = cicekBuyuklugu;
        this.cicekKokusu = cicekKokusu;
        this.cicekRengi = cicekRengi;
        this.ciceklenmeZamani = ciceklenmeZamani;
        this.cicekNotlar = cicekNotlar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCicekDurumu() {
        return cicekDurumu;
    }

    public void setCicekDurumu(String cicekDurumu) {
        this.cicekDurumu = cicekDurumu;
    }

    public String getCicekBuyuklugu() {
        return cicekBuyuklugu;
    }

    public void setCicekBuyuklugu(String cicekBuyuklugu) {
        this.cicekBuyuklugu = cicekBuyuklugu;
    }

    public String getCicekKokusu() {
        return cicekKokusu;
    }

    public void setCicekKokusu(String cicekKokusu) {
        this.cicekKokusu = cicekKokusu;
    }

    public String getCicekRengi() {
        return cicekRengi;
    }

    public void setCicekRengi(String cicekRengi) {
        this.cicekRengi = cicekRengi;
    }

    public String getCiceklenmeZamani() {
        return ciceklenmeZamani;
    }

    public void setCiceklenmeZamani(String ciceklenmeZamani) {
        this.ciceklenmeZamani = ciceklenmeZamani;
    }

    public String getCicekNotlar() {
        return cicekNotlar;
    }

    public void setCicekNotlar(String cicekNotlar) {
        this.cicekNotlar = cicekNotlar;
    }
}
