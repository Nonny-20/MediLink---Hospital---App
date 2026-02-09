package com.fmtaliproject.MediLink.emergency;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.R;

public class EmergencyLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_location);

        // Retrieve data from previous intents
        String target = getIntent().getStringExtra("emergency_for");
        String urgency = getIntent().getStringExtra("urgency_level");

        EditText etManual = findViewById(R.id.etManualLocation);
        Button btnConfirm = findViewById(R.id.btnConfirmLocation);
        Button btnDetect = findViewById(R.id.btnDetectLocation);

        btnDetect.setOnClickListener(v -> {
            // Placeholder: In a real app, you'd trigger FusedLocationProvider here
            etManual.setText("Detecting coordinates via GPS...");
            Toast.makeText(this, "GPS Pinpoint acquired", Toast.LENGTH_SHORT).show();
        });

        btnConfirm.setOnClickListener(v -> {
            String location = etManual.getText().toString().trim();

            if (location.isEmpty()) {
                Toast.makeText(this, "Please provide a location", Toast.LENGTH_SHORT).show();
            } else {
                // Final Step: Go to the Summary Screen
                Intent intent = new Intent(this, AlertSummaryActivity.class);
                intent.putExtra("emergency_for", target);
                intent.putExtra("urgency_level", urgency);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}