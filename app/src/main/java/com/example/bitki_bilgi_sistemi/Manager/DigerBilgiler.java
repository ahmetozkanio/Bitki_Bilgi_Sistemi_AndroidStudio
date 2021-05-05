package com.example.bitki_bilgi_sistemi.Manager;

public class DigerBilgiler {
    private int id;
    private String buyumeHizi;
    private String bakimIhtiyaci;
    private String zehirlilik;
    private String uretimi;

    public DigerBilgiler() {
    }

    public DigerBilgiler(int id, String buyumeHizi, String bakimIhtiyaci, String zehirlilik, String uretimi) {
        this.id = id;
        this.buyumeHizi = buyumeHizi;
        this.bakimIhtiyaci = bakimIhtiyaci;
        this.zehirlilik = zehirlilik;
        this.uretimi = uretimi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyumeHizi() {
        return buyumeHizi;
    }

    public void setBuyumeHizi(String buyumeHizi) {
        this.buyumeHizi = buyumeHizi;
    }

    public String getBakimIhtiyaci() {
        return bakimIhtiyaci;
    }

    public void setBakimIhtiyaci(String bakimIhtiyaci) {
        this.bakimIhtiyaci = bakimIhtiyaci;
    }

    public String getZehirlilik() {
        return zehirlilik;
    }

    public void setZehirlilik(String zehirlilik) {
        this.zehirlilik = zehirlilik;
    }

    public String getUretimi() {
        return uretimi;
    }

    public void setUretimi(String uretimi) {
        this.uretimi = uretimi;
    }
}
