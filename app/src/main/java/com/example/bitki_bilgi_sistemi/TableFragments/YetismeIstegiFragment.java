package com.example.bitki_bilgi_sistemi.TableFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bitki_bilgi_sistemi.R;


public class YetismeIstegiFragment extends Fragment {


    TextView gunIsigi,suIstegi,besinGereksinim,toprakIstegi,toprakDrenaji;




    public YetismeIstegiFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yetisme_istegi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        gunIsigi = view.findViewById(R.id.tv_gunIsıgı);
        suIstegi = view.findViewById(R.id.tv_suIstegi);
        besinGereksinim = view.findViewById(R.id.tv_besinGereksinim);
        toprakIstegi = view.findViewById(R.id.tv_toprakIstegi);
        toprakDrenaji = view.findViewById(R.id.tv_toprakDrenaj);


        Intent intent = getActivity().getIntent();
        gunIsigi.setText(intent.getStringExtra("gunIsigi"));
        suIstegi.setText(intent.getStringExtra("suIstegi"));
        besinGereksinim.setText(intent.getStringExtra("besin"));
        toprakIstegi.setText(intent.getStringExtra("toprakIstegi"));
        toprakDrenaji.setText(intent.getStringExtra("toprakDrenaji"));



    }
}