package com.example.bitki_bilgi_sistemi.TableFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bitki_bilgi_sistemi.R;


public class CicekFragment extends Fragment {


    TextView cicekDurumu,cicekBuyuklugu,cicekKokusu,
                cicekRengi,ciceklenmeZamani,cicekNotlar;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cicek, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cicekDurumu = view.findViewById(R.id.tv_cicekDurumu);
        cicekBuyuklugu = view.findViewById(R.id.tv_cicekBuyuklugu);
        cicekKokusu = view.findViewById(R.id.tv_cicekKokusu);
        cicekRengi = view.findViewById(R.id.tv_cicekRengi);
        ciceklenmeZamani = view.findViewById(R.id.tv_ciceklenmeZamani);
        cicekNotlar = view.findViewById(R.id.tv_cicekNotlar);



    }
}