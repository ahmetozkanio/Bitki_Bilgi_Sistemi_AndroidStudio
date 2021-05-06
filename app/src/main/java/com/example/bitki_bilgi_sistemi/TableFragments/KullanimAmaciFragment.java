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


public class KullanimAmaciFragment extends Fragment {

    TextView muhendislik , mimarlik,ek;

    public KullanimAmaciFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kullanim_amaci, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        muhendislik = view.findViewById(R.id.tv_muhendislikIslevi);
        mimarlik = view.findViewById(R.id.tv_mimarlikIslevi);
        ek = view.findViewById(R.id.tv_ekOzellikler);

        Intent intent = getActivity().getIntent();
        muhendislik.setText(intent.getStringExtra("muhendislik"));
        mimarlik.setText(intent.getStringExtra("mimarlik"));
        ek.setText(intent.getStringExtra("ekOzellik"));


    }
}