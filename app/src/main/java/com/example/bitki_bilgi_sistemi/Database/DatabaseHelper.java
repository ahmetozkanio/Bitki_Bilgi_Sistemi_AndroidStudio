package com.example.bitki_bilgi_sistemi.Database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.bitki_bilgi_sistemi.ContextInflater;
import com.example.bitki_bilgi_sistemi.Manager.Cicek;
import com.example.bitki_bilgi_sistemi.Manager.Genel;
import com.example.bitki_bilgi_sistemi.Manager.Habitus;

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




}
