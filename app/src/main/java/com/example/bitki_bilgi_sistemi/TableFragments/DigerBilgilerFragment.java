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


public class DigerBilgilerFragment extends Fragment {

    TextView buyumeHizi,bakimIhtiyaci,zehirlilik,uretimi;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diger_bilgiler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buyumeHizi = view.findViewById(R.id.tv_buyumeHizi);
        bakimIhtiyaci = view.findViewById(R.id.tv_bakimIhtiyaci);
        zehirlilik = view.findViewById(R.id.tv_zehirlilik);
        uretimi = view.findViewById(R.id.tv_uretimi);


    }
}