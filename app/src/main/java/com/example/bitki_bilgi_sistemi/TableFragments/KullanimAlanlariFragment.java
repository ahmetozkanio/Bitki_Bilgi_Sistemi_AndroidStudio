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


public class KullanimAlanlariFragment extends Fragment {


    TextView kirsalKullanim , kentselKullanim ,digerkullanim,peyzajTarzi,kullanimNot;




    public KullanimAlanlariFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kullanim_alanlari, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kirsalKullanim = view.findViewById(R.id.tv_kirsalKullanim);
        kentselKullanim = view.findViewById(R.id.tv_kentselKullanim);
        digerkullanim = view.findViewById(R.id.tv_digerKullanim);
        peyzajTarzi = view.findViewById(R.id.tv_peyzajTarzi);
        kullanimNot = view.findViewById(R.id.tv_kullanimAlanlariNotlar);


        Intent intent = getActivity().getIntent();
        kirsalKullanim.setText(intent.getStringExtra("kirsalKullanim"));
        kentselKullanim.setText(intent.getStringExtra("kentselKullanim"));
        digerkullanim.setText(intent.getStringExtra("digerKullanim"));
        peyzajTarzi.setText(intent.getStringExtra("peyzajTarzi"));
        kullanimNot.setText(intent.getStringExtra("kullanimNotlar"));




    }
}