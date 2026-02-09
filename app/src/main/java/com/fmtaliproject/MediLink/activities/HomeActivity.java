package com.fmtaliproject.MediLink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.fmtaliproject.MediLink.R;
import com.fmtaliproject.MediLink.chat.ChatActivity;
import com.fmtaliproject.MediLink.emergency.EmergencyActivity;

public class HomeActivity extends AppCompatActivity {

    private final Handler handler = new Handler();
    private Runnable emergencyRunnable;
    private static final int HOLD_DURATION = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // --- NAVIGATION LOGIC ---
        ImageView imgProfile = findViewById(R.id.imgProfile);
        if (imgProfile != null) {
            imgProfile.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            });
        }

        CardView cardComm = findViewById(R.id.cardComm);
        if (cardComm != null) {
            cardComm.setOnClickListener(v -> {
                startActivity(new Intent(HomeActivity.this, ChatActivity.class));
            });
        }

        // --- EMERGENCY 3-SECOND HOLD ---
        CardView cardEmergency = findViewById(R.id.cardEmergency);
        emergencyRunnable = () -> {
            startActivity(new Intent(HomeActivity.this, EmergencyActivity.class));
            Toast.makeText(HomeActivity.this, "Emergency Triggered!", Toast.LENGTH_SHORT).show();
        };

        if (cardEmergency != null) {
            cardEmergency.setOnTouchListener((v, event) -> {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler.postDelayed(emergencyRunnable, HOLD_DURATION);
                        v.animate().scaleX(0.92f).scaleY(0.92f).setDuration(200).start();
                        return true;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        handler.removeCallbacks(emergencyRunnable);
                        v.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).start();
                        v.performClick(); // Fixes the accessibility warning
                        return true;
                }
                return false;
            });
        }
    }
}