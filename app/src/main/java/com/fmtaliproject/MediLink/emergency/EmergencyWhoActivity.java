package com.fmtaliproject.MediLink.emergency;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.fmtaliproject.MediLink.R;

public class EmergencyWhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_who);

        CardView cardMyself = findViewById(R.id.cardMyself);
        CardView cardSomeoneElse = findViewById(R.id.cardSomeoneElse);

        // Click listener for "Myself"
        cardMyself.setOnClickListener(v -> {
            Intent intent = new Intent(EmergencyWhoActivity.this, EmergencyActivity.class);
            intent.putExtra("emergency_for", "myself");
            startActivity(intent);
        });

        // Click listener for "Someone Else"
        cardSomeoneElse.setOnClickListener(v -> {
            Intent intent = new Intent(EmergencyWhoActivity.this, EmergencyActivity.class);
            intent.putExtra("emergency_for", "someone_else");
            startActivity(intent);
        });
    }
}