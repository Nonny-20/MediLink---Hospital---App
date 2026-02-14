package com.fmtaliproject.MediLink.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.R;
// Corrected imports: Removing ".activities" because 'auth' is its own folder
import com.fmtaliproject.MediLink.auth.LoginActivity;
import com.fmtaliproject.MediLink.auth.SignupActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Initialize SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("MediLinkPrefs", Context.MODE_PRIVATE);

        // 2. Check if this is the first time the app is opened
        boolean isFirstTime = sharedPref.getBoolean("isFirstOpen", true);

        if (!isFirstTime) {
            // Returning user: Go straight to Login
            Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // 3. First-time user: Show the Welcome layout
        setContentView(R.layout.auth_welcome);

        Button loginBtn = findViewById(R.id.btnLogin);
        Button signUpBtn = findViewById(R.id.btnSignUp);

        if (loginBtn != null) {
            loginBtn.setOnClickListener(v -> {
                markFirstTimeDone(sharedPref);
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                finish();
            });
        }

        if (signUpBtn != null) {
            signUpBtn.setOnClickListener(v -> {
                markFirstTimeDone(sharedPref);
                startActivity(new Intent(WelcomeActivity.this, SignupActivity.class));
                finish();
            });
        }
    }

    private void markFirstTimeDone(SharedPreferences pref) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isFirstOpen", false);
        editor.apply();
    }
}