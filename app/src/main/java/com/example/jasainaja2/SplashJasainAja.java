package com.example.jasainaja2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashJasainAja extends AppCompatActivity {

    private static final int LamaTampil = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_jasain_aja);

        new Handler().postDelayed(() -> {
            Intent reg = new Intent(SplashJasainAja.this, RegisterActivity.class);
            startActivity(reg);
            finish();
        },LamaTampil);
    }
}