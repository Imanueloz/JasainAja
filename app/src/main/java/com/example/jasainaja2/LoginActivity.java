package com.example.jasainaja2;

import android.annotation.SuppressLint;
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

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
    Button btnlogin;
    TextView txtreg;
    FirebaseAuth fAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.txtUsername);
        edtPassword = findViewById(R.id.txtPassword);
        btnlogin = findViewById(R.id.btnLogin);
        txtreg = findViewById(R.id.txtlRegis);

        fAuth = FirebaseAuth.getInstance();
        
        btnlogin.setOnClickListener(view -> {
            String username = edtUsername.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();

            if(TextUtils.isEmpty(username)){
                edtUsername.setError("Email is required.");
                return;
            }
            if(TextUtils.isEmpty(password)){
                edtPassword.setError("Password is required.");
                return;
            }
            if(password.length() < 6){
                edtPassword.setError("Password Must be >= 6 Characters.");
            }
            else {
                fAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        btnlogin.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
        txtreg.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), RegisterActivity.class)));
    }
}