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

public class MeyveFragment extends Fragment {

    TextView meyveDurumu,meyveTipi,meyveBuyuklugu,meyveRengi,
                meyveYenilebilirlik,meyveZamani;

    public MeyveFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meyve, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        meyveDurumu = view.findViewById(R.id.tv_meyveDurumu);
        meyveBuyuklugu = view.findViewById(R.id.tv_meyveBuyuklugu);
        meyveTipi = view.findViewById(R.id.tv_meyveTipi);
        meyveRengi = view.findViewById(R.id.tv_meyveRengi);
        meyveYenilebilirlik = view.findViewById(R.id.tv_meyveYenilebilirlik);
        meyveZamani = view.findViewById(R.id.tv_meyveZamani);

        Intent intent = getActivity().getIntent();
        meyveDurumu.setText(intent.getStringExtra("meyveDurumu"));
        meyveBuyuklugu.setText(intent.getStringExtra("meyveBuyuklugu"));
        meyveTipi.setText(intent.getStringExtra("meyveTipi"));
        meyveRengi.setText(intent.getStringExtra("meyveRengi"));
        meyveYenilebilirlik.setText(intent.getStringExtra("meyveYenilebilirligi"));
        meyveZamani.setText(intent.getStringExtra("meyveZamani"));


    }
}