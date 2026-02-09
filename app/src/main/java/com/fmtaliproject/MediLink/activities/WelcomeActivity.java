package com.fmtaliproject.MediLink.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.auth.LoginActivity;
import com.fmtaliproject.MediLink.R;
import com.fmtaliproject.MediLink.auth.SignupActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 1. Initialize SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("MediLinkPrefs", Context.MODE_PRIVATE);

        // 2. Check if this is the first time (default is true if the key doesn't exist)
        boolean isFirstTime = sharedPref.getBoolean("isFirstOpen", true);

        if (!isFirstTime) {
            // If NOT the first time, jump straight to HomeActivity
            Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Close WelcomeActivity so user can't "back" into it
            return;   // Stop executing the rest of this method
        }

        // 3. If it IS the first time, show the layout and setup buttons
        setContentView(R.layout.activity_welcome);

        Button loginBtn = findViewById(R.id.btnLogin);
        Button signUpBtn = findViewById(R.id.btnSignUp);

        loginBtn.setOnClickListener(v -> {
            markFirstTimeDone(sharedPref);
            startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
        });

        signUpBtn.setOnClickListener(v -> {
            markFirstTimeDone(sharedPref);
            startActivity(new Intent(WelcomeActivity.this, SignupActivity.class));
        });
    }

    /**
     * Helper method to save the "returning user" flag so this screen
     * won't show up again on the next app launch.
     */
    private void markFirstTimeDone(SharedPreferences pref) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isFirstOpen", false);
        editor.apply();
    }
}