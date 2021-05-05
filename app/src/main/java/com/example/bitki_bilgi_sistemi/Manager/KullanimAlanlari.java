package com.example.bitki_bilgi_sistemi.Manager;

public class KullanimAlanlari {
    private int id;
    private String kirsalKullanimAlanlari;
    private String kentselKullanimAlanlari;
    private String digerKullanimAlanlari;
    private String peyzajTarzi;
    private String KullanimAlanlariNotlar;

    public KullanimAlanlari() {
    }

    public KullanimAlanlari(int id, String kirsalKullanimAlanlari, String kentselKullanimAlanlari, String digerKullanimAlanlari, String peyzajTarzi, String kullanimAlanlariNotlar) {
        this.id = id;
        this.kirsalKullanimAlanlari = kirsalKullanimAlanlari;
        this.kentselKullanimAlanlari = kentselKullanimAlanlari;
        this.digerKullanimAlanlari = digerKullanimAlanlari;
        this.peyzajTarzi = peyzajTarzi;
        this.KullanimAlanlariNotlar = kullanimAlanlariNotlar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKirsalKullanimAlanlari() {
        return kirsalKullanimAlanlari;
    }

    public void setKirsalKullanimAlanlari(String kirsalKullanimAlanlari) {
        this.kirsalKullanimAlanlari = kirsalKullanimAlanlari;
    }

    public String getKentselKullanimAlanlari() {
        return kentselKullanimAlanlari;
    }

    public void setKentselKullanimAlanlari(String kentselKullanimAlanlari) {
        this.kentselKullanimAlanlari = kentselKullanimAlanlari;
    }

    public String getDigerKullanimAlanlari() {
        return digerKullanimAlanlari;
    }

    public void setDigerKullanimAlanlari(String digerKullanimAlanlari) {
        this.digerKullanimAlanlari = digerKullanimAlanlari;
    }

    public String getPeyzajTarzi() {
        return peyzajTarzi;
    }

    public void setPeyzajTarzi(String peyzajTarzi) {
        this.peyzajTarzi = peyzajTarzi;
    }

    public String getKullanimAlanlariNotlar() {
        return KullanimAlanlariNotlar;
    }

    public void setKullanimAlanlariNotlar(String kullanimAlanlariNotlar) {
        KullanimAlanlariNotlar = kullanimAlanlariNotlar;
    }
}
