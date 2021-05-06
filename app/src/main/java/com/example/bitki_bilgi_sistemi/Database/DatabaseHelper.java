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

    public ArrayList<LatinName> latinNameList(){
        LatinName latinName = null;
        ArrayList<LatinName> nameArrayList = new ArrayList<>();
        openDatabase();

        Cursor cursor = myDatabase.rawQuery(sqlQuery.genelQuery(),null );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            latinName = new LatinName(cursor.getString(1));
            nameArrayList.add(latinName);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return nameArrayList;
    }


    //Genel Tablosu icin Veritabani Cekim ve Array List Ile Kullanim
    public ArrayList<Genel> genelList(){
        Genel genel = null;
        ArrayList<Genel> genelArrayList = new ArrayList<Genel>();
        openDatabase();

        Cursor cursor = myDatabase.rawQuery(sqlQuery.genelQuery(),null );
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
    public ArrayList<Habitus> habitusList(){

        Habitus habitus = null;
        ArrayList<Habitus> habitusArrayList = new ArrayList<Habitus>();

        openDatabase();
        Cursor cursor = myDatabase.rawQuery(sqlQuery.habitusQuery() ,null );
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
    public ArrayList<Cicek> cicekList(){
        Cicek cicek = null;
        ArrayList<Cicek> cicekArrayList = new ArrayList<Cicek>();

        openDatabase();
        Cursor cursor = myDatabase.rawQuery(sqlQuery.cicekQuery() ,null );
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
    public ArrayList<Yaprak> yaprakList(){
        Yaprak yaprak = null;
        ArrayList<Yaprak> yaprakArrayList = new ArrayList<Yaprak>();

        openDatabase();
        Cursor cursor = myDatabase.rawQuery(sqlQuery.yaprakQuery() ,null );
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
    public ArrayList<Meyve> meyveList(){
        Meyve meyve = null;
        ArrayList<Meyve> meyveArrayList = new ArrayList<Meyve>();

        openDatabase();
        Cursor cursor = myDatabase.rawQuery(sqlQuery.meyveQuery() ,null );
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
    public ArrayList<KullanimAlanlari> kullanimAlanlariList(){
        KullanimAlanlari kullanimAlanlari = null;
        ArrayList<KullanimAlanlari> kullanimAlanlariArrayList = new ArrayList<KullanimAlanlari>();

        openDatabase();
        Cursor cursor = myDatabase.rawQuery(sqlQuery.kullanimAlanlariQuery() ,null );
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
    public ArrayList<KullanimAmaci> kullanimAmaciList(){
        KullanimAmaci kullanimAmaci = null;
        ArrayList<KullanimAmaci> kullanimAmaciArrayList = new ArrayList<KullanimAmaci>();

        openDatabase();
        Cursor cursor = myDatabase.rawQuery(sqlQuery.kullanimAmaciQuery() ,null );
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
    public ArrayList<DigerBilgiler> digerBilgilerList(){
        DigerBilgiler digerBilgiler = null;
        ArrayList<DigerBilgiler> digerBilgilerArrayList = new ArrayList<DigerBilgiler>();

        openDatabase();
        Cursor cursor = myDatabase.rawQuery(sqlQuery.digerBilgilerQuery() ,null );
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
    public ArrayList<YetismeIstegi> yetismeIstegiList(){
        YetismeIstegi yetismeIstegi = null;
        ArrayList<YetismeIstegi> yetismeIstegiArrayList = new ArrayList<YetismeIstegi>();

        openDatabase();
        Cursor cursor = myDatabase.rawQuery(sqlQuery.yetismeIstegiQuery() ,null );
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
