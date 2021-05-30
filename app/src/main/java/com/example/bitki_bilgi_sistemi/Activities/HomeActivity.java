package com.example.bitki_bilgi_sistemi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bitki_bilgi_sistemi.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    ImageButton info,qr;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    button = findViewById(R.id.plant_btn);
    imageView = findViewById(R.id.imageView);
    info = findViewById(R.id.info_btn);
    qr = findViewById(R.id.qr_btn);




    }

    public void plantButton(View view) {
        intent = new Intent(HomeActivity.this, ListActivity.class);
        startActivity(intent);
    }

    public void qrButton(View view) {

    }

    public void infoButton(View view) {
    }


}