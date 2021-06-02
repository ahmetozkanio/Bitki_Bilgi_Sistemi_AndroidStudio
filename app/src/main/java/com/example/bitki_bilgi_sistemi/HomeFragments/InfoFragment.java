package com.example.bitki_bilgi_sistemi.HomeFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.bitki_bilgi_sistemi.R;



public class InfoFragment extends Fragment {


    ImageView backBtn;
    ImageView linkedinBtn;
    ImageView githubBtn;
    ImageView isteBtn;
    Intent intent;
    Context context;
    Uri link;
    public InfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        backBtn = view.findViewById(R.id.homeBack);
        linkedinBtn = view.findViewById(R.id.linkedin);
        githubBtn = view.findViewById(R.id.github);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButton(view);
            }
        });
        linkedinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linkedinButton(view);
            }
        });
        githubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                githubButton(view);
            }
        });


    }
    public void backButton(View view){
        NavDirections navDirections = InfoFragmentDirections.actionİnfoFragmentToHomeFragment();
        Navigation.findNavController(view).navigate(navDirections);
    }
    public void linkedinButton(View view){
        link = Uri.parse("https://www.linkedin.com/in/ahmet-ozkan");
        intent =new Intent(Intent.ACTION_VIEW,link);
        startActivity(intent);
    }
    public void githubButton(View view){
        link = Uri.parse("https://www.github.com/aozkan9");
        intent =new Intent(Intent.ACTION_VIEW,link);
        startActivity(intent);
    }

}