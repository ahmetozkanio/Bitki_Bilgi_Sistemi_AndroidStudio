package com.example.bitki_bilgi_sistemi.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bitki_bilgi_sistemi.R;
import com.example.bitki_bilgi_sistemi.Adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    TextView plantName;
    ImageButton listBack;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listBack = findViewById(R.id.listBack);
        plantName = findViewById(R.id.title);
        Intent intent= getIntent();
        plantName.setText(intent.getStringExtra("plantTitle"));



        //Tablayaout olusturulup View adaptatorune baglandi
        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager) ;
        //


    }



    //************************************************************
    //List Back button
    public void listBackButton(View view){
        intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }

    //************************************************************























}