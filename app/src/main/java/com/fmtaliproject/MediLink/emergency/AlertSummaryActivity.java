package com.fmtaliproject.MediLink.emergency;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.R;

public class AlertSummaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_summary);

        // Get the level passed from the previous screen
        String level = getIntent().getStringExtra("URGENCY_LEVEL");

        TextView tvLevel = findViewById(R.id.summaryUrgency);
        if (level != null) {
            tvLevel.setText(level);
            // Optional: You can change the color of the tag programmatically here based on level
        }
    }
}