package com.example.bitki_bilgi_sistemi.Activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


import com.example.bitki_bilgi_sistemi.Adapter.GenelAdapter;
import com.example.bitki_bilgi_sistemi.Database.DatabaseHelper;
import com.example.bitki_bilgi_sistemi.Database.SqlQuery;
import com.example.bitki_bilgi_sistemi.Manager.Genel;
import com.example.bitki_bilgi_sistemi.Manager.Habitus;
import com.example.bitki_bilgi_sistemi.R;


public class BilgiActivity extends AppCompatActivity {
    //Modeller
    ArrayList<Genel> genelArrayList = new ArrayList<Genel>();
    ArrayList<Habitus> habitusArrayList = new ArrayList<Habitus>();



    DatabaseHelper myDBHELPER;
    ArrayAdapter adapter;

    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi);

    //Bitkinin adini gostermek icin listview
    ListView listView = findViewById(R.id.listVPlantName);

    //Fragrment Bilgilerine gitmek icin intent
    intent = new Intent(BilgiActivity.this,MainActivity.class);

    //Veri tabani erisimi
    myDBHELPER = new DatabaseHelper(BilgiActivity.this,"plant");
    File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
   try { if (!database.exists()){ myDBHELPER.getReadableDatabase();
        if (!copyDatabase(BilgiActivity.this)) { return; } }
   } catch (IOException e) { e.printStackTrace(); }




        SqlQuery sqlQuery =new SqlQuery();

        System.out.println("habitus = "+sqlQuery.habitusQuery());









  //Genel Tablosu ListView de gosterim ve fragment bilgi aktarimi icin
   genelArrayList = myDBHELPER.genelList();
   adapter = new GenelAdapter(genelArrayList);
   adapter.notifyDataSetChanged();
   listView.setAdapter(adapter);



   //Habitus Tablosu
    habitusArrayList = myDBHELPER.habitusList();



   //listView tiklama aninda yapilacaklar
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            System.out.println("id = "+habitusArrayList.get(position).getId()+
                    "Boyu = "+habitusArrayList.get(position).getBoyu()+
                    "Capi = "+habitusArrayList.get(position).getCapi()+
                    "Notlar = "+habitusArrayList.get(position).getHabitusNotlar());

            //GenelFragment Tablosu Bilgi Aktarim Islemi
            genelPush(position);
            //HabitusFragment Tablosu Bilgi Aktarim Islemi
            habitusPush(position);

            startActivity(intent);
        }
    });
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