package com.example.bitki_bilgi_sistemi.Activities;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ImageButton;
import android.widget.ListView;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;



import com.example.bitki_bilgi_sistemi.Adapter.GenelAdapter;
import com.example.bitki_bilgi_sistemi.Database.DatabaseHelper;

import com.example.bitki_bilgi_sistemi.Manager.Cicek;
import com.example.bitki_bilgi_sistemi.Manager.DigerBilgiler;
import com.example.bitki_bilgi_sistemi.Manager.Genel;
import com.example.bitki_bilgi_sistemi.Manager.Habitus;
import com.example.bitki_bilgi_sistemi.Manager.KullanimAlanlari;
import com.example.bitki_bilgi_sistemi.Manager.KullanimAmaci;
import com.example.bitki_bilgi_sistemi.Manager.Meyve;
import com.example.bitki_bilgi_sistemi.Manager.Yaprak;
import com.example.bitki_bilgi_sistemi.Manager.YetismeIstegi;
import com.example.bitki_bilgi_sistemi.R;



public class ListActivity extends AppCompatActivity {
    //Modeller
    ArrayList<Genel> genelArrayList = new ArrayList<Genel>();
    ArrayList<Habitus> habitusArrayList = new ArrayList<Habitus>();
    ArrayList<Cicek> cicekArrayList = new ArrayList<Cicek>();
    ArrayList<Yaprak> yaprakArrayList = new ArrayList<Yaprak>();
    ArrayList<Meyve> meyveArrayList= new ArrayList<Meyve>();
    ArrayList<KullanimAlanlari> kullanimAlanlariArrayList = new ArrayList<KullanimAlanlari>();
    ArrayList<KullanimAmaci> kullanimAmaciArrayList = new ArrayList<KullanimAmaci>();
    ArrayList<DigerBilgiler> digerBilgilerArrayList = new ArrayList<DigerBilgiler>();
    ArrayList<YetismeIstegi> yetismeIstegiArrayList = new ArrayList<YetismeIstegi>();


    ArrayList<Genel> latinName;
    DatabaseHelper myDBHELPER;
    ArrayAdapter adapter;

    Intent intent;

    SearchView search;
    ListView listView;
    ImageButton backIcon;


    //Sql search
    String keyword ="";
    boolean value =false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi);

    //Back Button
        backIcon = findViewById(R.id.homeBack);
    //Bitkinin adini gostermek icin listview
        listView = findViewById(R.id.listVPlantName);
    //Search bar Listview Tanimlama
        search= findViewById(R.id.search_bar);

    //Fragrment Bilgilerine gitmek icin intent
    intent = new Intent(ListActivity.this, PlantInfoActivity.class);

    //Veri tabani erisimi
    myDBHELPER = new DatabaseHelper(ListActivity.this,"plant");
    File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
   try { if (!database.exists()){ myDBHELPER.getReadableDatabase();
        if (!copyDatabase(ListActivity.this)) { return; } }
   } catch (IOException e) { e.printStackTrace(); }








  //Genel Tablosu ListView de gosterim ve fragment bilgi aktarimi icin
   genelArrayList = myDBHELPER.genelList(keyword,value);
   adapter = new GenelAdapter(genelArrayList);
   adapter.notifyDataSetChanged();
   listView.setAdapter(adapter);


   //Search kullanimi
        search();



    //Genel Tablosu
    genelArrayList = myDBHELPER.genelList(keyword,value);
    //Habitus Tablosu
    habitusArrayList = myDBHELPER.habitusList(keyword,value);
    //Cicek Tablosu
    cicekArrayList = myDBHELPER.cicekList(keyword,value);
    //Yaprak Tablosu
    yaprakArrayList = myDBHELPER.yaprakList(keyword,value);
    //Meyve Tablosu
    meyveArrayList = myDBHELPER.meyveList(keyword,value);
    //Kullanim Alanlari Tablosu
    kullanimAlanlariArrayList = myDBHELPER.kullanimAlanlariList(keyword,value);
    //Kullanim Amaci Tablosu
    kullanimAmaciArrayList = myDBHELPER.kullanimAmaciList(keyword,value);
    //Diger Bilgiler Tablosu
    digerBilgilerArrayList = myDBHELPER.digerBilgilerList(keyword,value);
    //Yetisme Istegi Tablosu
    yetismeIstegiArrayList = myDBHELPER.yetismeIstegiList(keyword,value);








        //listView tiklama aninda yapilacaklar
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //Main Activity title
            plantTitlePush((int) id);



            //GenelFragment Tablosu Bilgi Aktarim Islemi
            genelPush(position);
            //HabitusFragment Tablosu Bilgi Aktarim Islemi
            habitusPush(position);
            //CicekFragment Tablosu Bilgi Aktarim Islemi
            cicekPush(position);
            //YaprakFragment Tablosu Bilgi Aktarim Islemi
            yaprakPush(position);
            //MeyveFragment Tablosu Bilgi Aktarim Islemi
            meyvePush(position);
            //kullanimAlanlariFragment Tablosu Bilgi Aktarim Islemi
            kullanimAlanlariPush(position);
            //kullanimAmaciFragment Tablosu Bilgi Aktarim Islemi
            kullanimAmaciPush(position);
            //digerBilgilerFragment Tablosu Bilgi Aktarim Islemi
            digerBilgilerPush(position);
            //YetismeIstegiFragment Tablosu Bilgi Aktarim Islemi
            yetismeIstegiPush(position);

            startActivity(intent);
        }
    });

    }

    //************************************************************
    //Home Back button
    public void homeBackButton(View view){
        intent = new Intent(ListActivity.this,HomeActivity.class);
        startActivity(intent);
    }

    //************************************************************




    public void search(){
        SearchManager searchManager =(SearchManager) getSystemService(SEARCH_SERVICE);
        search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        search.setSubmitButtonEnabled(true);
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchListName(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchListName(newText);
                return false;
            }
        });
    }
    private  void searchListName(String keyword){
        value =true;
       latinName= myDBHELPER.searchList(keyword,value);
        listView.clearTextFilter();

        if (latinName != null) {
            listView.setAdapter(new GenelAdapter(latinName));
            genelArrayList = myDBHELPER.genelList(keyword,value);
            habitusArrayList = myDBHELPER.habitusList(keyword,value);
            cicekArrayList = myDBHELPER.cicekList(keyword,value);
            yaprakArrayList = myDBHELPER.yaprakList(keyword,value);
            meyveArrayList = myDBHELPER.meyveList(keyword,value);
            kullanimAlanlariArrayList = myDBHELPER.kullanimAlanlariList(keyword,value);
            kullanimAmaciArrayList = myDBHELPER.kullanimAmaciList(keyword,value);
            digerBilgilerArrayList = myDBHELPER.digerBilgilerList(keyword,value);
            yetismeIstegiArrayList = myDBHELPER.yetismeIstegiList(keyword,value);
        }

    }





    public void plantTitlePush(int id){

        intent.putExtra("plantTitle",genelArrayList.get(id).getLatinName());

    }

    //GenelFragment Tablosu Bilgi Aktarim Islemi
    public void genelPush(int position){

        intent.putExtra("latinName",genelArrayList.get(position).getLatinName());
        intent.putExtra("turkishName",genelArrayList.get(position).getTurkishName());
        intent.putExtra("buyumeFormu",genelArrayList.get(position).getBuyumeFormu());
        intent.putExtra("anavatani",genelArrayList.get(position).getAnavatani());
        intent.putExtra("yetistigiBolge",genelArrayList.get(position).getYetisitigiBolge());
        intent.putExtra("ailesi",genelArrayList.get(position).getAilesi());
        intent.putExtra("notlar",genelArrayList.get(position).getNotlar());
    }

    //HabitusFragment Tablosu Bilgi Aktarim Islemi
    public void habitusPush(int position){

        intent.putExtra("sekli",habitusArrayList.get(position).getSekli());
        intent.putExtra("boyu",habitusArrayList.get(position).getBoyu());
        intent.putExtra("capi",habitusArrayList.get(position).getCapi());
        intent.putExtra("dokusu",habitusArrayList.get(position).getDokusu());
        intent.putExtra("habitusNotlar",habitusArrayList.get(position).getHabitusNotlar());
    }
    //CicekFragment Tablosu Bilgi Aktarim Islemi
    public void cicekPush(int position){

        intent.putExtra("cicekDurumu",cicekArrayList.get(position).getCicekDurumu());
        intent.putExtra("cicekBuyuklugu",cicekArrayList.get(position).getCicekBuyuklugu());
        intent.putExtra("cicekKokusu",cicekArrayList.get(position).getCicekKokusu());
        intent.putExtra("cicekRengi",cicekArrayList.get(position).getCicekRengi());
        intent.putExtra("ciceklenmeZamani",cicekArrayList.get(position).getCiceklenmeZamani());
        intent.putExtra("cicekNotlar",cicekArrayList.get(position).getCicekNotlar());
    }
    //YaprakFragment Tablosu Bilgi Aktarim Islemi
    public void yaprakPush(int position){

        intent.putExtra("yaprakDokme",yaprakArrayList.get(position).getYaprakDokme());
        intent.putExtra("yaprakTipi",yaprakArrayList.get(position).getYaprakTipi());
        intent.putExtra("yaprakSekli",yaprakArrayList.get(position).getYaprakSekli());
        intent.putExtra("yaprakBuyuklugu",yaprakArrayList.get(position).getYaprakBuyuklugu());
        intent.putExtra("yaprakKokusu",yaprakArrayList.get(position).getYaprakKokusu());
        intent.putExtra("yaprakDokusu",yaprakArrayList.get(position).getYaprakDokusu());
        intent.putExtra("yaprakRengi",yaprakArrayList.get(position).getYaprakRengi());
        intent.putExtra("yaprakGuzRengi",yaprakArrayList.get(position).getYaprakGuzRengi());
        intent.putExtra("yaprakNotlar",yaprakArrayList.get(position).getYaprakNotlar());

    }
    //MeyveFragment Tablosu Bilgi Aktarim Islemi
    public void meyvePush(int position){

        intent.putExtra("meyveDurumu",meyveArrayList.get(position).getMeyvedurumu());
        intent.putExtra("meyveTipi",meyveArrayList.get(position).getMeyveTipi());
        intent.putExtra("meyveBuyuklugu",meyveArrayList.get(position).getMeyveBuyuklugu());
        intent.putExtra("meyveRengi",meyveArrayList.get(position).getMeyveRengi());
        intent.putExtra("meyveYenilebilirligi",meyveArrayList.get(position).getMeyveYenilebilirligi());
        intent.putExtra("meyveZamani",meyveArrayList.get(position).getMeyveZamani());
    }
    //KullanimAlanlariFragment Tablosu Bilgi Aktarim Islemi
    public void kullanimAlanlariPush(int position){

        intent.putExtra("kirsalKullanim",kullanimAlanlariArrayList.get(position).getKirsalKullanimAlanlari());
        intent.putExtra("kentselKullanim",kullanimAlanlariArrayList.get(position).getKentselKullanimAlanlari());
        intent.putExtra("digerKullanim",kullanimAlanlariArrayList.get(position).getDigerKullanimAlanlari());
        intent.putExtra("peyzajTarzi",kullanimAlanlariArrayList.get(position).getPeyzajTarzi());
        intent.putExtra("kullanimNotlar",kullanimAlanlariArrayList.get(position).getKullanimAlanlariNotlar());
    }
    //KullanimAmaciFragment Tablosu Bilgi Aktarim Islemi
    public void kullanimAmaciPush(int position){

        intent.putExtra("muhendislik",kullanimAmaciArrayList.get(position).getMuhendislikIslevleri());
        intent.putExtra("mimarlik",kullanimAmaciArrayList.get(position).getMimarlikIslevleri());
        intent.putExtra("ekOzellik",kullanimAmaciArrayList.get(position).getEkOzellikler());
    }

    //DigerBilgilerFragment Tablosu Bilgi Aktarim Islemi
    public void digerBilgilerPush(int position){

        intent.putExtra("buyumeHizi",digerBilgilerArrayList.get(position).getBuyumeHizi());
        intent.putExtra("bakimIhtiyaci",digerBilgilerArrayList.get(position).getBakimIhtiyaci());
        intent.putExtra("zehirlilik",digerBilgilerArrayList.get(position).getZehirlilik());
        intent.putExtra("uretim",digerBilgilerArrayList.get(position).getUretimi());

    }
    //YetismeIstegiFragment Tablosu Bilgi Aktarim Islemi
    public void yetismeIstegiPush(int position){

        intent.putExtra("gunIsigi",yetismeIstegiArrayList.get(position).getGunIsigiIstegi());
        intent.putExtra("suIstegi",yetismeIstegiArrayList.get(position).getSuIstegi());
        intent.putExtra("besin",yetismeIstegiArrayList.get(position).getBesinGereksimi());
        intent.putExtra("toprakIstegi",yetismeIstegiArrayList.get(position).getToprakIstegi());
        intent.putExtra("toprakDrenaji",yetismeIstegiArrayList.get(position).getToprakDrenaji());

    }























    public Boolean copyDatabase(Context context) throws IOException {
        InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
        String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
        File file = new File(outFileName);
        file.getParentFile().mkdir();
        OutputStream outputStream= new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length = 0;

        while((length = inputStream.read(buffer)) > 0)
        {
            outputStream.write(buffer,0, length);
        }
        outputStream.flush();
        outputStream.close();
        return  true;

    }





}