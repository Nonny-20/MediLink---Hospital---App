package com.fmtaliproject.MediLink.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.activities.HomeActivity;
import com.fmtaliproject.MediLink.R;

public class ConfirmDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_confirm_details);

        // 1. Initialize views using the EXACT IDs from your XML
        TextView tvConfirmName = findViewById(R.id.tvConfirmName);
        TextView tvConfirmID = findViewById(R.id.tvConfirmID);
        TextView tvConfirmEmail = findViewById(R.id.tvConfirmEmail);
        Button btnConfirm = findViewById(R.id.btnConfirm);
        TextView tvGoBack = findViewById(R.id.tvGoBack);

        // 2. Retrieve the booking data (passed from BookingActivity)
        // We aren't displaying these yet because your XML is for Personal Data,
        // but we keep them here so we can send them to the hospital later!
        String type = getIntent().getStringExtra("EXTRA_TYPE");
        String date = getIntent().getStringExtra("EXTRA_DATE");

        // 3. Set Placeholder/Actual User Data
        // (Later, we will pull this from SharedPreferences or Firebase)
        if (tvConfirmName != null) tvConfirmName.setText("Johnathan Doe");
        if (tvConfirmID != null) tvConfirmID.setText("ML-12345");
        if (tvConfirmEmail != null) tvConfirmEmail.setText("j.doe@example.com");

        // 4. Confirm & Proceed Logic
        if (btnConfirm != null) {
            btnConfirm.setOnClickListener(v -> {
                showPendingStatusDialog(type, date);
            });
        }

        // 5. Back / Sign Out Logic
        if (tvGoBack != null) {
            tvGoBack.setOnClickListener(v -> finish());
        }
    }

    private void showPendingStatusDialog(String type, String date) {
        new AlertDialog.Builder(this)
                .setTitle("Booking Submitted")
                .setMessage("Your request for a " + type + " appointment on " + date +
                        " has been sent. It is currently PENDING review for doctor availability.")
                .setCancelable(false)
                .setPositiveButton("Understood", (dialog, which) -> {
                    Intent intent = new Intent(ConfirmDetailsActivity.this, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                })
                .show();
    }
}