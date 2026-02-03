package com.fmtaliproject.MediLink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Connects to activity_signup.xml
        setContentView(R.layout.activity_signup);

        // Initialize components
        // Inside onCreate
        TextView btnBack = findViewById(R.id.tvBack); // Matches your XML id: tvBack
        Button btnRegister = findViewById(R.id.btnNext); // Matches your XML id: btnNext

        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        if (btnRegister != null) {
            btnRegister.setOnClickListener(v -> {
                // Since this is a multi-step form, you can add your
                // step-switching logic here or just go to Login for now
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            });
        }
    }
}