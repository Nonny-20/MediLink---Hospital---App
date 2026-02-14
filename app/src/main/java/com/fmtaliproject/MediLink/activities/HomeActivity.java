package com.fmtaliproject.MediLink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.R;
import com.fmtaliproject.MediLink.chat.ChatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_home);

        // 1. Bottom Navigation / Profile
        ImageView imgProfile = findViewById(R.id.imgProfile);

        // 2. Dashboard Cards (These IDs must exist in main_home.xml)
        LinearLayout cardBook = findViewById(R.id.cardBook);
        LinearLayout cardRecords = findViewById(R.id.cardRecords);
        LinearLayout cardChat = findViewById(R.id.cardChat);

        // 3. The Login Prompt section
        View loginSection = findViewById(R.id.loginSection);

        // --- LOGIC ---

        // Hide the "Sign in" prompt because the user just logged in
        if (loginSection != null) {
            loginSection.setVisibility(View.GONE);
        }

        if (imgProfile != null) {
            imgProfile.setOnClickListener(v ->
                    startActivity(new Intent(this, ProfileActivity.class)));
        }

        if (cardBook != null) {
            cardBook.setOnClickListener(v ->
                    startActivity(new Intent(this, BookingActivity.class)));
        }

        if (cardRecords != null) {
            cardRecords.setOnClickListener(v ->
                    startActivity(new Intent(this, RecordsActivity.class)));
        }

        if (cardChat != null) {
            cardChat.setOnClickListener(v ->
                    startActivity(new Intent(this, ChatActivity.class)));
        }
    }
}