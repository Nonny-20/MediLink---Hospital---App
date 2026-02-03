package com.fmtaliproject.MediLink;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Link the CardView back button from your XML
        CardView btnBack = findViewById(R.id.btnBack);

        // Handle Back Button Click
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }
}