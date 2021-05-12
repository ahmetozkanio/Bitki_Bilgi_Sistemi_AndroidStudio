package com.example.bitki_bilgi_sistemi.Database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.bitki_bilgi_sistemi.ContextInflater;
import com.example.bitki_bilgi_sistemi.Manager.Cicek;
import com.example.bitki_bilgi_sistemi.Manager.DigerBilgiler;
import com.example.bitki_bilgi_sistemi.Manager.Genel;
import com.example.bitki_bilgi_sistemi.Manager.Habitus;
import com.example.bitki_bilgi_sistemi.Manager.KullanimAlanlari;
import com.example.bitki_bilgi_sistemi.Manager.KullanimAmaci;
import com.example.bitki_bilgi_sistemi.Manager.LatinName;
import com.example.bitki_bilgi_sistemi.Manager.Meyve;
import com.example.bitki_bilgi_sistemi.Manager.Yaprak;
import com.example.bitki_bilgi_sistemi.Manager.YetismeIstegi;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public  static  String DBNAME;
    public  static  String TABLE;
    public static  final String DBLOCATION = "/data/data/" + ContextInflater.context.getPackageName()+"/databases/";
    private Context myContext;
    private SQLiteDatabase myDatabase;

    //Sql Sorgulari icin Class
     SqlQuery sqlQuery = new SqlQuery();

    public DatabaseHelper(Context context,String dbNAME){
        super(context,DBNAME,null,1);
        DBNAME= dbNAME + ".sqlite";
        myContext = context;
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void openDatabase(){
        String dbPath = myContext.getDatabasePath(DBNAME).getPath();
        if (myDatabase != null && myDatabase.isOpen())
            return;
        myDatabase = SQLiteDatabase.openDatabase(dbPath,null,SQLiteDatabase.OPEN_READWRITE);
    }


    public void  closeDatabase()
    {
        if (myDatabase != null)
            myDatabase.close();
    }

    public ArrayList<Genel> searchList(String keyword,boolean value){
        Genel genel = null;
        ArrayList<Genel> nameArrayList = new ArrayList<>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.latinNameQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.latinNameQuery(false),null);



        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            genel = new Genel(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7));
            nameArrayList.add(genel);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return nameArrayList;
    }


    //Genel Tablosu icin Veritabani Cekim ve Array List Ile Kullanim
    public ArrayList<Genel> genelList(String keyword,boolean value){
        Genel genel = null;
        ArrayList<Genel> genelArrayList = new ArrayList<Genel>();
        openDatabase();
Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.latinNameQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.latinNameQuery(false),null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            genel = new Genel(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7));
            genelArrayList.add(genel);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return genelArrayList;
    }

    //Habitus Tablosu icin Veritabani Cekim ve Array List Ile Kullanim
    public ArrayList<Habitus> habitusList(String keyword,boolean value){

        Habitus habitus = null;
        ArrayList<Habitus> habitusArrayList = new ArrayList<Habitus>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.habitusQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.habitusQuery(false),null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            habitus = new Habitus(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5));
            habitusArrayList.add(habitus);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return habitusArrayList;
    }
    //Cicek Tablosu icin Veritabani Cekim ve Array List e aktarim
    public ArrayList<Cicek> cicekList(String keyword,boolean value){
        Cicek cicek = null;
        ArrayList<Cicek> cicekArrayList = new ArrayList<Cicek>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.cicekQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.cicekQuery(false),null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            cicek = new Cicek(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));
            cicekArrayList.add(cicek);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return cicekArrayList;
    }

    //Yaprak Tablosu icin Veritabani Cekim ve Array List e aktarim
    public ArrayList<Yaprak> yaprakList(String keyword,boolean value){
        Yaprak yaprak = null;
        ArrayList<Yaprak> yaprakArrayList = new ArrayList<Yaprak>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.yaprakQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.yaprakQuery(false),null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            yaprak = new Yaprak(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9));
            yaprakArrayList.add(yaprak);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return yaprakArrayList;
    }


    //Meyve Tablosu icin Veritabani Cekim ve Array List e aktarim
    public ArrayList<Meyve> meyveList(String keyword,boolean value){
        Meyve meyve = null;
        ArrayList<Meyve> meyveArrayList = new ArrayList<Meyve>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.meyveQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.meyveQuery(false),null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            meyve = new Meyve(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));
            meyveArrayList.add(meyve);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return meyveArrayList;
    }
    //Kullanim Alanlari Tablosu icin Veritabani Cekim ve Array List e aktarim
    public ArrayList<KullanimAlanlari> kullanimAlanlariList(String keyword,boolean value){
        KullanimAlanlari kullanimAlanlari = null;
        ArrayList<KullanimAlanlari> kullanimAlanlariArrayList = new ArrayList<KullanimAlanlari>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.kullanimAlanlariQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.kullanimAlanlariQuery(false),null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            kullanimAlanlari = new KullanimAlanlari(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5));
            kullanimAlanlariArrayList.add(kullanimAlanlari);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return kullanimAlanlariArrayList;
    }
    //Kullanim Amaci Tablosu icin Veritabani Cekim ve Array List e aktarim
    public ArrayList<KullanimAmaci> kullanimAmaciList(String keyword,boolean value){
        KullanimAmaci kullanimAmaci = null;
        ArrayList<KullanimAmaci> kullanimAmaciArrayList = new ArrayList<KullanimAmaci>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.kullanimAmaciQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.kullanimAmaciQuery(false),null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            kullanimAmaci = new KullanimAmaci(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3));
            kullanimAmaciArrayList.add(kullanimAmaci);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return kullanimAmaciArrayList;
    }


    //Diger Bilgiler Tablosu icin Veritabani Cekim ve Array List e aktarim
    public ArrayList<DigerBilgiler> digerBilgilerList(String keyword,boolean value){
        DigerBilgiler digerBilgiler = null;
        ArrayList<DigerBilgiler> digerBilgilerArrayList = new ArrayList<DigerBilgiler>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.digerBilgilerQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.digerBilgilerQuery(false),null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            digerBilgiler = new DigerBilgiler(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));
            digerBilgilerArrayList.add(digerBilgiler);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return digerBilgilerArrayList;
    }
    //Yetisme Istegi Tablosu icin Veritabani Cekim ve Array List e aktarim
    public ArrayList<YetismeIstegi> yetismeIstegiList(String keyword,boolean value){
        YetismeIstegi yetismeIstegi = null;
        ArrayList<YetismeIstegi> yetismeIstegiArrayList = new ArrayList<YetismeIstegi>();

        openDatabase();
        Cursor cursor;
        if (value)
            cursor = myDatabase.rawQuery(sqlQuery.yetismeIstegiQuery(true), new String[] {"%"+keyword+"%"});
        else
            cursor = myDatabase.rawQuery(sqlQuery.yetismeIstegiQuery(false),null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            yetismeIstegi = new YetismeIstegi(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5));
            yetismeIstegiArrayList.add(yetismeIstegi);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return yetismeIstegiArrayList;
    }



}
