package com.fmtaliproject.MediLink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button loginBtn = findViewById(R.id.btnLogin);
        Button signUpBtn = findViewById(R.id.btnSignUp);

        loginBtn.setOnClickListener(v -> {
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        });

        signUpBtn.setOnClickListener(v -> {
            startActivity(new Intent(WelcomeActivity.this, SignupActivity.class));
        });
    }
}