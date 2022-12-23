package com.example.jasainaja2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterJasa extends ArrayAdapter {
    String[] namaJasa;
    int[] imgJasa;
    Activity activity;

    public AdapterJasa(String[] namaJasa, int[] imgJasa, Activity activity){
        super(activity, R.layout.list_jasa, namaJasa);
        this.namaJasa = namaJasa;
        this.imgJasa = imgJasa;
        this.activity = activity;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"}) View v = inflater.inflate(R.layout.list_jasa, null);

        ImageView gambar;
        TextView namajasa;


        gambar = v.findViewById(R.id.img_jasa);
        namajasa = v.findViewById(R.id.nama_jasa);

        gambar.setImageResource(imgJasa[position]);
        namajasa.setText(namaJasa[position]);

        return v;
    }
}
