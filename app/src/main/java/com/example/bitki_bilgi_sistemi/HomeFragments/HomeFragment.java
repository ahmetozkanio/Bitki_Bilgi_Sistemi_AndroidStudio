package com.example.bitki_bilgi_sistemi.HomeFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bitki_bilgi_sistemi.Activities.ListActivity;
import com.example.bitki_bilgi_sistemi.R;



public class HomeFragment extends Fragment {

    Button button;
    ImageView imageView;
    ImageButton info,qr;
    Intent intent;
    Context context;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = container.getContext();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.plant_btn);
        imageView =view.findViewById(R.id.imageView);
        info = view.findViewById(R.id.info_btn);
        qr =view.findViewById(R.id.qr_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              plantButton(view);
            }
        });
        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrButton(view);
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoButton(view);
            }
        });
    }

    public void plantButton(View view) {
        intent = new Intent(context,ListActivity.class);
        startActivity(intent);
    }

    public void qrButton(View view) {
        Toast.makeText(context,"En yakin zamanda qr code aktif edilecektir...", Toast.LENGTH_LONG).show();
    }

    public void infoButton(View view) {
        NavDirections navDirections = HomeFragmentDirections.actionHomeFragmentToİnfoFragment();
        Navigation.findNavController(view).navigate(navDirections);

    }

}