package com.example.bitki_bilgi_sistemi.TableFragments;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bitki_bilgi_sistemi.Database.DatabaseHelper;
import com.example.bitki_bilgi_sistemi.Manager.Genel;
import com.example.bitki_bilgi_sistemi.R;

import java.util.ArrayList;


public class GenelFragment extends Fragment {

    TextView latinName,turkceName,buyumeFormu,
    anavatani,yetistigiBolge,ailesi,notlar;





    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_genel,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        latinName = view.findViewById(R.id.tv_latin);
        turkceName = view.findViewById(R.id.tv_turkce);
        buyumeFormu = view.findViewById(R.id.tv_buyumeFormu);
        anavatani = view.findViewById(R.id.tv_anavatani);
        yetistigiBolge = view.findViewById(R.id.tv_yetistigiBolge);
        ailesi = view.findViewById(R.id.tv_ailesi);
        notlar = view.findViewById(R.id.tv_genelNotlar);


    Intent intent = getActivity().getIntent();
        latinName.setText(intent.getStringExtra("latinName"));
        turkceName.setText(intent.getStringExtra("turkishName"));
        buyumeFormu.setText(intent.getStringExtra("buyumeFormu"));
        anavatani.setText(intent.getStringExtra("anavatani"));
        yetistigiBolge.setText(intent.getStringExtra("yetistigiBolge"));
        ailesi.setText(intent.getStringExtra("ailesi"));
        notlar.setText(intent.getStringExtra("notlar"));
    }







}