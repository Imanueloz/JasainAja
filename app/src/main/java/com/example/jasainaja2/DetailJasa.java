package com.example.jasainaja2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailJasa extends AppCompatActivity {

    ImageView jasamasuk;
    TextView ketejasa;
    Button btnpesan;

    int gambarjasa;

    String keteranganjasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jasa);

        jasamasuk = findViewById(R.id.gambarterima);
        ketejasa = findViewById(R.id.ketjasa);
        final Spinner List = findViewById(R.id.spnitem);
        btnpesan = findViewById(R.id.btnPesan);

        Bundle bundle = getIntent().getExtras();

        gambarjasa = bundle.getInt("gambarjasa");
        jasamasuk.setImageResource(gambarjasa);
        keteranganjasa = bundle.getString("jasaketer");
        ketejasa.setText(keteranganjasa);

        btnpesan.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Saya Memesan"+ List.getSelectedItem(), Toast.LENGTH_SHORT).show());
    }
}