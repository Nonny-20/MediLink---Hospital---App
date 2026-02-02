package com.fmtaliproject.MediLink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Profile icon → Profile screen
        ImageView imgProfile = findViewById(R.id.imgProfile);
        if (imgProfile != null) {
            imgProfile.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            });
        }

        // Communication card → Chat screen
        CardView cardComm = findViewById(R.id.cardComm);
        if (cardComm != null) {
            cardComm.setOnClickListener(v -> {
                Intent intent = new Intent(HomeActivity.this, ChatActivity.class);
                startActivity(intent);
            });
        }
    }
}
