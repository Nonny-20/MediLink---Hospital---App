package com.fmtaliproject.MediLink.activities;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.fmtaliproject.MediLink.R;

public class RecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feat_records);

        // 1. Initialize the Back Button Card
        CardView btnBack = findViewById(R.id.btnBack);

        // 2. Back Button Logic
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> {
                // Return to the previous screen (HomeActivity)
                finish();
            });
        }

        // 3. (Optional) Initialize click listeners for specific cards
        // For example, if you want them to be able to tap a medication
        // to see more details in the future.
    }
}