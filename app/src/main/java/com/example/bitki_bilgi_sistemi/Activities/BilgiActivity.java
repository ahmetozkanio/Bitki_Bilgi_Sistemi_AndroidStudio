package com.example.bitki_bilgi_sistemi.Activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


import com.example.bitki_bilgi_sistemi.Adapter.GenelAdapter;
import com.example.bitki_bilgi_sistemi.Database.DatabaseHelper;

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
import com.example.bitki_bilgi_sistemi.R;
import com.google.android.material.internal.TextWatcherAdapter;


public class BilgiActivity extends AppCompatActivity {
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
    ArrayList<LatinName> latinNameArrayList=new ArrayList<>();


    DatabaseHelper myDBHELPER;
    ArrayAdapter adapter;

    Intent intent;

    EditText search;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi);

    //Bitkinin adini gostermek icin listview
        listView = findViewById(R.id.listVPlantName);
    //Search bar Listview Tanimlama
        search= findViewById(R.id.search);

    //Fragrment Bilgilerine gitmek icin intent
    intent = new Intent(BilgiActivity.this,MainActivity.class);

    //Veri tabani erisimi
    myDBHELPER = new DatabaseHelper(BilgiActivity.this,"plant");
    File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
   try { if (!database.exists()){ myDBHELPER.getReadableDatabase();
        if (!copyDatabase(BilgiActivity.this)) { return; } }
   } catch (IOException e) { e.printStackTrace(); }








  //Genel Tablosu ListView de gosterim ve fragment bilgi aktarimi icin
   latinNameArrayList = myDBHELPER.latinNameList();
   adapter = new GenelAdapter(latinNameArrayList);
   adapter.notifyDataSetChanged();
   listView.setAdapter(adapter);


    //Genel Tablosu
    genelArrayList = myDBHELPER.genelList();
    //Habitus Tablosu
    habitusArrayList = myDBHELPER.habitusList();
    //Cicek Tablosu
    cicekArrayList = myDBHELPER.cicekList();
    //Yaprak Tablosu
    yaprakArrayList = myDBHELPER.yaprakList();
    //Meyve Tablosu
    meyveArrayList = myDBHELPER.meyveList();
    //Kullanim Alanlari Tablosu
    kullanimAlanlariArrayList = myDBHELPER.kullanimAlanlariList();
    //Kullanim Amaci Tablosu
    kullanimAmaciArrayList = myDBHELPER.kullanimAmaciList();
    //Diger Bilgiler Tablosu
    digerBilgilerArrayList = myDBHELPER.digerBilgilerList();
    //Yetisme Istegi Tablosu
    yetismeIstegiArrayList = myDBHELPER.yetismeIstegiList();








        //listView tiklama aninda yapilacaklar
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //Main Activity title
            plantTitlePush(position);



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

            //Search Bar listeleme
            search.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    (BilgiActivity.this).adapter.getFilter().filter(s);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });






    }

    public void plantTitlePush(int position){
        intent.putExtra("plantTitle",genelArrayList.get(position).getLatinName());

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