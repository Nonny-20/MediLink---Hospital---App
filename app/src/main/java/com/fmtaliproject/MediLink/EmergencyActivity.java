package com.fmtaliproject.MediLink;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class EmergencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // This links the Java file to your exact XML layout
        setContentView(R.layout.activity_emergency);

        // 1. Initialize the Urgency Level Cards
        CardView cardCritical = findViewById(R.id.cardCritical);
        CardView cardUrgent = findViewById(R.id.cardUrgent);
        CardView cardNonUrgent = findViewById(R.id.cardNonUrgent);

        // 2. Handle CRITICAL Selection
        cardCritical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmergencyLevel("CRITICAL");
            }
        });

        // 3. Handle URGENT Selection
        cardUrgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmergencyLevel("URGENT");
            }
        });

        // 4. Handle NON-URGENT Selection
        cardNonUrgent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmergencyLevel("NON-URGENT");
            }
        });
    }

    /**
     * Helper method to simulate sending the alert to the hospital
     */
    private void sendEmergencyLevel(String level) {
        // In a real app, this is where you'd send data to a database
        Toast.makeText(this, "Alerting Hospital: " + level + " priority set.", Toast.LENGTH_LONG).show();

        // After selecting, you might want to close the screen or go to a "Help is on the way" screen
        // finish();
    }
}