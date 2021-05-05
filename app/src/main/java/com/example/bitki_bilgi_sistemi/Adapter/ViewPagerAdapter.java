package com.example.bitki_bilgi_sistemi.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bitki_bilgi_sistemi.TableFragments.GenelFragment;
import com.example.bitki_bilgi_sistemi.TableFragments.HabitusFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //fragmentlari secme
        switch (position){
            case 0:
                return new GenelFragment();
            case 1:
                return new HabitusFragment();
            case 2:
                return new GenelFragment();
            case 3:
                return new HabitusFragment();
            case 4:
                return new GenelFragment();
            case 5:
                return new HabitusFragment();
            case 6:
                return new GenelFragment();
            case 7:
                return new HabitusFragment();
            case 8:
                return new HabitusFragment();
            case 9:
                return new HabitusFragment();
            default:
                return new GenelFragment();

        }

    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title ="";    //tablayaout basliklari atandi

        switch (position){
            case 0:
                title = "Genel";
                break;
            case 1:
                title = "Habitus";
                break;
            case 2:
                title = "Görseller";
                break;
            case 3:
                title = "Çiçek";
                break;
            case 4:
                title = "Yaprak";
                break;
            case 5:
                title = "Meyve";
                break;
            case 6:
                title = "Kullanım alanları";
                break;
            case 7:
                title = "Kullanım amacı";
                break;
            case 8:
                title = "Yetişme isteği";
                break;
            case 9:
                title = "Diğer bilgiler";
                break;
        }
        return title;




    }

    @Override
    public int getCount() {
        return 10;  //kac tane view olusturulacak onun sayisi
    }
}
