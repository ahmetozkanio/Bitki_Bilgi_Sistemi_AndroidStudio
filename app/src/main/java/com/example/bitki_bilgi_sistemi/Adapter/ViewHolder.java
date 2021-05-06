package com.example.bitki_bilgi_sistemi.Adapter;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bitki_bilgi_sistemi.Manager.Genel;
import com.example.bitki_bilgi_sistemi.Manager.LatinName;
import com.example.bitki_bilgi_sistemi.R;

public  class ViewHolder {
    public TextView textView;


    public ViewHolder(View view){
        textView = view.findViewById(R.id.tvPlantName);

    }
    public void ListViewName(final ArrayAdapter<LatinName> adapter, final LatinName item , final int position){
        textView.setText(item.getName()+position);
    }

}