package com.fmtaliproject.MediLink.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.activities.HomeActivity;
import com.fmtaliproject.MediLink.R;

public class ConfirmDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details);

        // 1. Link the Confirm Button
        Button btnConfirm = findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(v -> {
            // Move to the Home Screen
            Intent intent = new Intent(ConfirmDetailsActivity.this, HomeActivity.class);
            startActivity(intent);
            finish(); // This prevents the user from clicking "back" to see their details again
        });

        // 2. Link the Sign Out / Back text
        TextView tvGoBack = findViewById(R.id.tvGoBack);
        tvGoBack.setOnClickListener(v -> finish());
    }
}