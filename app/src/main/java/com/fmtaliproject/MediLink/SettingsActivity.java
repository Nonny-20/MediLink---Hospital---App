package com.fmtaliproject.MediLink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // 1. Back Button Functionality
        ImageView btnBack = findViewById(R.id.btnBackSettings);
        btnBack.setOnClickListener(v -> finish());

        // 2. Log Out Functionality
        CardView btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(v -> {
            // Clears all previous activities and goes back to Login
            Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}