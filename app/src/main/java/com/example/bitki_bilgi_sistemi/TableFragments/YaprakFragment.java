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


public class YaprakFragment extends Fragment {

    TextView yaprakDokme,yaprakTipi,yaprakSekli,
            yaprakBuyuklugu,yaprakKokusu,yaprakDokusu
            ,yaprakRengi,yaprakGuzRengi,yaprakNotlar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yaprak, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        yaprakDokme = view.findViewById(R.id.tv_yaprakDokme);
        yaprakTipi = view.findViewById(R.id.tv_yaprakTipi);
        yaprakSekli = view.findViewById(R.id.tv_yaprakSekli);
        yaprakBuyuklugu = view.findViewById(R.id.tv_yaprakBuyuklugu);
        yaprakKokusu = view.findViewById(R.id.tv_yaprakKokusu);
        yaprakDokusu = view.findViewById(R.id.tv_yaprakDokusu);
        yaprakRengi = view.findViewById(R.id.tv_yaprakRengi);
        yaprakGuzRengi = view.findViewById(R.id.tv_yaprakGüzRengi);
        yaprakNotlar = view.findViewById(R.id.tv_yaprakNotlar);

        Intent intent = getActivity().getIntent();
        yaprakDokme.setText(intent.getStringExtra("yaprakDokme"));
        yaprakTipi.setText(intent.getStringExtra("yaprakTipi"));
        yaprakSekli.setText(intent.getStringExtra("yaprakSekli"));
        yaprakBuyuklugu.setText(intent.getStringExtra("yaprakBuyuklugu"));
        yaprakKokusu.setText(intent.getStringExtra("yaprakKokusu"));
        yaprakDokusu.setText(intent.getStringExtra("yaprakDokusu"));
        yaprakRengi.setText(intent.getStringExtra("yaprakRengi"));
        yaprakGuzRengi.setText(intent.getStringExtra("yaprakGuzRengi"));
        yaprakNotlar.setText(intent.getStringExtra("yaprakNotlar"));




    }
}