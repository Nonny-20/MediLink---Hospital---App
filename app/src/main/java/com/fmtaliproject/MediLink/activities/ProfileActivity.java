package com.fmtaliproject.MediLink.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.fmtaliproject.MediLink.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ensure your XML file is named main_profile.xml
        setContentView(R.layout.main_profile);

        // 1. Back Button
        CardView btnBack = findViewById(R.id.btnBack);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 2. Navigation to Medical Records
        TextView btnMedicalRecords = findViewById(R.id.btnMedicalRecords);
        if (btnMedicalRecords != null) {
            btnMedicalRecords.setOnClickListener(v -> {
                // Navigates to the RecordsActivity we built earlier
                Intent intent = new Intent(ProfileActivity.this, RecordsActivity.class);
                startActivity(intent);
            });
        }

        // 3. Logout Logic
        TextView btnSignOut = findViewById(R.id.btnSignOut);
        if (btnSignOut != null) {
            btnSignOut.setOnClickListener(v -> {
                // Clear user session here if you have one
                Toast.makeText(this, "Logged out successfully", Toast.LENGTH_SHORT).show();

                // Navigate back to Login (assuming LoginActivity exists)
                // Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                // startActivity(intent);
                finish();
            });
        }
    }
}