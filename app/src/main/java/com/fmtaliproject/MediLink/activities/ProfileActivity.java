package com.fmtaliproject.MediLink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.fmtaliproject.MediLink.R;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // 1. Back Button
        CardView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 2. Medical Records Navigation
        RelativeLayout btnMedicalRecords = findViewById(R.id.btnMedicalRecords);
        if (btnMedicalRecords != null) {
            btnMedicalRecords.setOnClickListener(v -> {
                // Pointing to your new MedicalRecordsActivity
                Intent intent = new Intent(ProfileActivity.this, MedicalRecordsActivity.class);
                startActivity(intent);
            });
        }

        // 3. Appointment History (Optional Routing)
        RelativeLayout btnAppointmentHistory = findViewById(R.id.btnAppointmentHistory);
        if (btnAppointmentHistory != null) {
            btnAppointmentHistory.setOnClickListener(v -> {
                // Start History Activity if you have one
            });
        }
    }
}