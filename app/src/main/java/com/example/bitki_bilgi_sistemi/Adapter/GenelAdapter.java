package com.example.bitki_bilgi_sistemi.Adapter;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;

import com.example.bitki_bilgi_sistemi.Activities.BilgiActivity;
import com.example.bitki_bilgi_sistemi.ContextInflater;
import com.example.bitki_bilgi_sistemi.Database.DatabaseHelper;
import com.example.bitki_bilgi_sistemi.Manager.Genel;
import com.example.bitki_bilgi_sistemi.Manager.LatinName;
import com.example.bitki_bilgi_sistemi.R;

import java.util.ArrayList;
import java.util.List;

public class GenelAdapter extends ArrayAdapter<LatinName> {

    BilgiActivity bilgiActivity = new BilgiActivity();

    public  GenelAdapter(ArrayList<LatinName> latinNameArrayList){
      super(ContextInflater.context, R.layout.plant_name_listview,latinNameArrayList);
  }


    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        ViewHolder holder;
        LatinName item = getItem(position);
        if (convertView ==null)
        {
            convertView = ContextInflater.inflater.inflate(R.layout.plant_name_listview,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.ListViewName(this,item,position);
        return convertView;
    }


}
