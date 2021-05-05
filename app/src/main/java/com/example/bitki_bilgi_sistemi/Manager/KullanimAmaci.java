package com.example.bitki_bilgi_sistemi.Manager;

public class KullanimAmaci {
    private int id;
    private String muhendislikIslevleri;
    private String mimarlikIslevleri;
    private String ekOzellikler;

    public KullanimAmaci() {
    }

    public KullanimAmaci(int id, String muhendislikIslevleri, String mimarlikIslevleri, String ekOzellikler) {
        this.id = id;
        this.muhendislikIslevleri = muhendislikIslevleri;
        this.mimarlikIslevleri = mimarlikIslevleri;
        this.ekOzellikler = ekOzellikler;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMuhendislikIslevleri() {
        return muhendislikIslevleri;
    }

    public void setMuhendislikIslevleri(String muhendislikIslevleri) {
        this.muhendislikIslevleri = muhendislikIslevleri;
    }

    public String getMimarlikIslevleri() {
        return mimarlikIslevleri;
    }

    public void setMimarlikIslevleri(String mimarlikIslevleri) {
        this.mimarlikIslevleri = mimarlikIslevleri;
    }

    public String getEkOzellikler() {
        return ekOzellikler;
    }

    public void setEkOzellikler(String ekOzellikler) {
        this.ekOzellikler = ekOzellikler;
    }
}
