package com.example.bitki_bilgi_sistemi.Database;




public class SqlQuery{
    String sql;
    String orderBy=" ORDER BY genel.latince_ismi ASC";
    boolean keyword = false;
    String latince = "latince_ismi ";

    //Search Icin Sorgu
    public String latinNameQuery(boolean value){
        keyword = value;
        if (keyword)
            sql ="select * from "+"genel "+"where "+latince+"like ?"+orderBy ;
        else
            sql ="SELECT * FROM "+ "genel" +orderBy;

        return sql;
    }

    //Genel Tablosu Sorgu
    public String genelQuery(){
        sql ="SELECT * FROM "+ "genel" +orderBy;
        return sql;
    }

    //Habitus Tablosu Sorgu Genel Tablosundaki Bitki isimlerine gore ID eslesmesi yaparak
    //List View Positiona gore fragment a aktarim yapar Butun tablolar icin gecerli hepsi Genel Tablosu ile ortak calisir.
    public String habitusQuery(boolean value){
        keyword = value;
        if (keyword)
            sql ="SELECT * FROM habitus INNER JOIN genel ON habitus.habitus_id = genel.genel_id WHERE "+latince+"like ?"+orderBy;
        else
            sql ="SELECT * FROM habitus INNER JOIN genel ON habitus.habitus_id = genel.genel_id"+orderBy;

         return sql;


    }
    public String cicekQuery(boolean value){
        keyword = value;
        if (keyword)
            sql ="SELECT * FROM cicek INNER JOIN genel ON cicek.cicek_id = genel.genel_id WHERE "+latince+"like ?"+orderBy;
        else
            sql ="SELECT * FROM cicek INNER JOIN genel ON cicek.cicek_id = genel.genel_id"+orderBy;

        return sql;
    }
    public String yaprakQuery(boolean value){
        keyword = value;
        if (keyword)
        sql ="SELECT * FROM yaprak INNER JOIN genel ON yaprak.yaprak_id = genel.genel_id WHERE "+latince+"like ?"+orderBy;
        else
        sql ="SELECT * FROM yaprak INNER JOIN genel ON yaprak.yaprak_id = genel.genel_id"+orderBy;
        return sql;
    }
    public String meyveQuery(boolean value){
        keyword = value;
        if (keyword)
            sql ="SELECT * FROM meyve INNER JOIN genel ON meyve.meyve_id = genel.genel_id WHERE "+latince+"like ?"+orderBy;
        else
            sql ="SELECT * FROM meyve INNER JOIN genel ON meyve.meyve_id = genel.genel_id"+orderBy;

        return sql;
    }
    public String kullanimAlanlariQuery(boolean value){
        keyword = value;
        if (keyword)
            sql ="SELECT * FROM kullanim_alanlari INNER JOIN genel ON kullanim_alanlari.kullanimalanlari_id = genel.genel_id WHERE "+latince+"like ?"+orderBy;
        else
            sql ="SELECT * FROM kullanim_alanlari INNER JOIN genel ON kullanim_alanlari.kullanimalanlari_id = genel.genel_id"+orderBy;



        return sql;
    }
    public String kullanimAmaciQuery(boolean value){
        keyword = value;

        if (keyword)
            sql ="SELECT * FROM kullanim_amaci INNER JOIN genel ON kullanim_amaci.kullanim_amaci_id = genel.genel_id WHERE "+latince+"like ?"+orderBy;
        else
            sql ="SELECT * FROM kullanim_amaci INNER JOIN genel ON kullanim_amaci.kullanim_amaci_id = genel.genel_id"+orderBy;

        return sql;
    }
    public String yetismeIstegiQuery(boolean value){
        keyword = value;

        if (keyword)
            sql ="SELECT * FROM yetisme_istegi INNER JOIN genel ON yetisme_istegi.yetisme_istegi_id = genel.genel_id WHERE "+latince+"like ?"+orderBy;
        else
            sql ="SELECT * FROM yetisme_istegi INNER JOIN genel ON yetisme_istegi.yetisme_istegi_id = genel.genel_id"+orderBy;


        return sql;
    }
    public String digerBilgilerQuery(boolean value){
        keyword = value;

        if (keyword)
            sql ="SELECT * FROM diger_bilgiler INNER JOIN genel ON diger_bilgiler.diger_bilgiler_id = genel.genel_id WHERE "+latince+"like ?"+orderBy;
        else
            sql ="SELECT * FROM diger_bilgiler INNER JOIN genel ON diger_bilgiler.diger_bilgiler_id = genel.genel_id"+orderBy;


        return sql;
    }
}
