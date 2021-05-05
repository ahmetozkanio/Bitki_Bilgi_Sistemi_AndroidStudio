package com.example.bitki_bilgi_sistemi.Manager;

public class Habitus {
    private int id;
    private String sekli;
    private String boyu;
    private String capi;
    private String dokusu;
    private String habitusNotlar;

    public Habitus() {
    }

    public Habitus(int id, String sekli, String boyu, String capi, String dokusu, String habitusNotlar) {
        this.id = id;
        this.sekli = sekli;
        this.boyu = boyu;
        this.capi = capi;
        this.dokusu = dokusu;
        this.habitusNotlar = habitusNotlar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSekli() {
        return sekli;
    }

    public void setSekli(String sekli) {
        this.sekli = sekli;
    }

    public String getBoyu() {
        return boyu;
    }

    public void setBoyu(String boyu) {
        this.boyu = boyu;
    }

    public String getCapi() {
        return capi;
    }

    public void setCapi(String capi) {
        this.capi = capi;
    }

    public String getDokusu() {
        return dokusu;
    }

    public void setDokusu(String dokusu) {
        this.dokusu = dokusu;
    }

    public String getHabitusNotlar() {
        return habitusNotlar;
    }

    public void setHabitusNotlar(String habitusNotlar) {
        this.habitusNotlar = habitusNotlar;
    }
}
