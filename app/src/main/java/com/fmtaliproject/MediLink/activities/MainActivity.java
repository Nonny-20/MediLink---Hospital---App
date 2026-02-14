package com.fmtaliproject.MediLink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.fmtaliproject.MediLink.R;
// Standard imports
import com.fmtaliproject.MediLink.chat.ChatActivity;
// Ensure these paths match your actual folder structure:
// import com.fmtaliproject.MediLink.activities.BookingActivity;
// import com.fmtaliproject.MediLink.activities.SettingsActivity;
// import com.fmtaliproject.MediLink.activities.ProfileActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_dashboard);

        // 1. Chat & AI Support
        CardView cardChat = findViewById(R.id.cardChat);
        if (cardChat != null) {
            cardChat.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            });
        }

        // 2. Booking New Appointment
        CardView btnGoToBooking = findViewById(R.id.btnGoToBooking);
        if (btnGoToBooking != null) {
            btnGoToBooking.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, BookingActivity.class);
                startActivity(intent);
            });
        }

        // 3. Settings (Top Right Icon)
        ImageView btnSettings = findViewById(R.id.btnSettings);
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            });
        }

        // 4. Profile (Top Right Icon)
        ImageView btnProfile = findViewById(R.id.btnProfile);
        if (btnProfile != null) {
            btnProfile.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            });
        }
    }
}