package com.example.jasainaja2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    EditText rUsername, rPassword, rConPassword;
    Button rbtnRegister;
    TextView rbtnLogin;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        rUsername = findViewById(R.id.txtUsernameReg);
        rPassword = findViewById(R.id.txtPasswordReg);
        rConPassword = findViewById(R.id.txtConPassword);
        rbtnRegister = findViewById(R.id.btnRegis);
        rbtnLogin = findViewById(R.id.txtLoginR);

        fAuth = FirebaseAuth.getInstance();

        rbtnRegister.setOnClickListener(v -> {
            String username = rUsername.getText().toString().trim();
            String password = rPassword.getText().toString().trim();
            String cpassword = rConPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username)){
                rUsername.setError("Username is required.");
                return;
            }
            if(TextUtils.isEmpty(password)){
                rPassword.setError("Password is required.");
                return;
            }
            if(password.length() < 6){
                rPassword.setError("Password Must be >= 6 Characters.");
                return;
            }
            if(!password.equals(cpassword)){
                rPassword.setError("Password mismatch.");
            }
            else {
                fAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
                    if(task.isSuccessful()) {
                        Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(RegisterActivity.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        rbtnLogin.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),LoginActivity.class)));
    }
}