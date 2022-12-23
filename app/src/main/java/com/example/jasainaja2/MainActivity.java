package com.example.jasainaja2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nama_jasa = {"Coding","Design","Ketik","Melukis","Menjahit"};
        int[] img_jasa = {R.drawable.jasa_coding, R.drawable.jasa_design, R.drawable.jasa_ketik, R.drawable.jasa_melukis, R.drawable.jasa_menjahit};

        listView = findViewById(R.id.listjasa);
        ListAdapter adapter = new AdapterJasa(nama_jasa, img_jasa, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String Nama_Jasa = nama_jasa[position];
            int Img_Jasa = img_jasa[position];
            Intent intent = new Intent(MainActivity.this, DetailJasa.class);
            intent.putExtra("namajasa", Nama_Jasa);
            intent.putExtra("gambarjasa", Img_Jasa);
            startActivity(intent);
        });
    }
}