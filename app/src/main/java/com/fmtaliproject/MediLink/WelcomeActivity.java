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

        // Navigate to Login
        loginBtn.setOnClickListener(v -> {
            // We will create LoginActivity next to fix the red error
            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        // Navigate to Signup
        signUpBtn.setOnClickListener(v -> {
            // We will create SignupActivity next to fix the red error
            Intent intent = new Intent(WelcomeActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }
}