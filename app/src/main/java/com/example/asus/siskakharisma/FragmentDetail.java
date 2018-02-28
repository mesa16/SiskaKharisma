package com.example.asus.siskakharisma;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by ASUS on 2/23/2018.
 */

public class FragmentDetail extends Fragment {
    private TextView dtvnim, dtvnama, dtvemail, dtvstatus;
    private ImageView imgitem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_detail, null);

        imgitem = (ImageView) view.findViewById(R.id.img_item);

        dtvnim = (TextView) view.findViewById(R.id.tvNim);
        dtvnama = (TextView) view.findViewById(R.id.tvNama);
        dtvemail = (TextView) view.findViewById(R.id.tvEmail);
        dtvstatus = (TextView) view.findViewById(R.id.tvStatus);



        return view;
    }

    public void displayData(Mahasiswa mahasiswa){
        String nim = mahasiswa.getNim();
        String angkatan = nim.substring(3,5);
        String prodi = nim.substring(0,3);
        String imageUrl = "https://siska4.kharisma.ac.id/assets/img/foto/mhs/"+angkatan+"/"+prodi+"/"+nim+".jpg";
        Glide.with(this).load(imageUrl).into(imgitem);

        dtvnim.setText(mahasiswa.getNim());
        dtvnama.setText(mahasiswa.getNama());
        dtvemail.setText(mahasiswa.getEmail());
        dtvstatus.setText(mahasiswa.getStatus());
    }
}
