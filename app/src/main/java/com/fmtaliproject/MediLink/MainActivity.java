package com.fmtaliproject.MediLink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --- Navigation Setup ---

        // 1. Emergency Card Navigation
        CardView cardEmergency = findViewById(R.id.cardEmergency);
        if (cardEmergency != null) {
            cardEmergency.setOnClickListener(v -> {
                Intent intent = new Intent(this, EmergencyActivity.class);
                startActivity(intent);
            });
        }

        // 2. Communication Hub (Chat & AI Support)
        CardView cardChat = findViewById(R.id.cardChat);
        if (cardChat != null) {
            cardChat.setOnClickListener(v -> {
                // Assuming your chat logic is in ChatActivity
                Intent intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
            });
        }

        // 3. Top Right Settings Icon
        ImageView btnSettings = findViewById(R.id.btnSettings);
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> {
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
            });
        }

        // 4. Top Right Profile Icon
        ImageView btnProfile = findViewById(R.id.btnProfile);
        if (btnProfile != null) {
            btnProfile.setOnClickListener(v -> {
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
            });
        }
    }

    /**
     * Optional: Logic for handling back presses or
     * refreshing data when returning to the dashboard
     */
    @Override
    protected void onResume() {
        super.onResume();
        // This is a good place to refresh patient data if needed
    }
}