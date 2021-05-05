package com.example.bitki_bilgi_sistemi.TableFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bitki_bilgi_sistemi.R;

public class HabitusFragment extends Fragment {

    TextView sekli,boyu,capi,dokusu,habitusNotlar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_habitus,container,false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sekli = view.findViewById(R.id.tv_sekli);
        boyu = view.findViewById(R.id.tv_boyu);
        capi = view.findViewById(R.id.tv_capi);
        dokusu = view.findViewById(R.id.tv_dokusu);
        habitusNotlar = view.findViewById(R.id.tv_habitusNotlar);

        //ListView Tiklandigi anda Fragment taki text View lere ID ye gore bilgiler yazilir
        Intent intent = getActivity().getIntent();
        sekli.setText(intent.getStringExtra("sekli"));
        boyu.setText(intent.getStringExtra("boyu"));
        capi.setText(intent.getStringExtra("capi"));
        dokusu.setText(intent.getStringExtra("dokusu"));
        habitusNotlar.setText(intent.getStringExtra("habitusNotlar"));

    }
}
