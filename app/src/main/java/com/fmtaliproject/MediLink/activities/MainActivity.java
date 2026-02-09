package com.fmtaliproject.MediLink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.fmtaliproject.MediLink.R;
import com.fmtaliproject.MediLink.chat.ChatActivity;
import com.fmtaliproject.MediLink.emergency.EmergencyActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Emergency
        CardView cardEmergency = findViewById(R.id.cardEmergency);
        if (cardEmergency != null) {
            cardEmergency.setOnClickListener(v -> startActivity(new Intent(this, EmergencyActivity.class)));
        }

        // 2. Chat
        CardView cardChat = findViewById(R.id.cardChat);
        if (cardChat != null) {
            cardChat.setOnClickListener(v -> startActivity(new Intent(this, ChatActivity.class)));
        }

        // 3. Booking - This will now work without the error
        CardView btnGoToBooking = findViewById(R.id.btnGoToBooking);
        if (btnGoToBooking != null) {
            btnGoToBooking.setOnClickListener(v -> startActivity(new Intent(this, BookingActivity.class)));
        }

        // 4. Settings
        ImageView btnSettings = findViewById(R.id.btnSettings);
        if (btnSettings != null) {
            btnSettings.setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));
        }

        // 5. Profile
        ImageView btnProfile = findViewById(R.id.btnProfile);
        if (btnProfile != null) {
            btnProfile.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        }
    }
}