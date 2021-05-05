package com.example.bitki_bilgi_sistemi.Database;




public class SqlQuery{
    String sql;

    //Genel Tablosu Sorgu
    public String genelQuery(){
        sql ="SELECT * FROM "+ "genel" +" ORDER BY latince_ismi ASC";
        return sql;
    }

    //Habitus Tablosu Sorgu Genel Tablosundaki Bitki isimlerine gore ID eslesmesi yaparak
    //List View Positiona gore fragment a aktarim yapar Butun tablolar icin gecerli hepsi Genel Tablosu ile ortak calisir.
    public String habitusQuery(){
         sql ="SELECT * FROM habitus INNER JOIN genel ON habitus.habitus_id = genel.genel_id ORDER BY genel.latince_ismi ASC";
        return sql;
    }
    public String cicekQuery(){
        sql ="SELECT * FROM "+ "genel" +" ORDER BY latince_ismi ASC";
        return sql;
    }
    public String yaprakQuery(){
        sql ="SELECT * FROM "+ "genel" +" ORDER BY latince_ismi ASC";
        return sql;
    }
    public String meyveQuery(){
        sql ="SELECT * FROM "+ "genel" +" ORDER BY latince_ismi ASC";
        return sql;
    }
    public String kullanimAlanlariQuery(){
        sql ="SELECT * FROM "+ "genel" +" ORDER BY latince_ismi ASC";
        return sql;
    }
    public String kullanimAmaciQuery(){
         sql ="SELECT * FROM "+ "genel" +" ORDER BY latince_ismi ASC";
        return sql;
    }
    public String yetismeIstegiQuery(){
        sql ="SELECT * FROM "+ "genel" +" ORDER BY latince_ismi ASC";
        return sql;
    }
    public String digerBilgilerQuery(){
        sql ="SELECT * FROM "+ "genel" +" ORDER BY latince_ismi ASC";
        return sql;
    }
}
