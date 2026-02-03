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

        // Emergency Card Navigation
        CardView cardEmergency = findViewById(R.id.cardEmergency);
        if (cardEmergency != null) {
            cardEmergency.setOnClickListener(v ->
                    startActivity(new Intent(this, EmergencyActivity.class)));
        }

        // Top Right Settings Icon
        ImageView btnSettings = findViewById(R.id.btnSettings);
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v ->
                    startActivity(new Intent(this, SettingsActivity.class)));
        }

        // Top Right Profile Icon
        ImageView btnProfile = findViewById(R.id.btnProfile);
        if (btnProfile != null) {
            btnProfile.setOnClickListener(v ->
                    startActivity(new Intent(this, ProfileActivity.class)));
        }
    }
}