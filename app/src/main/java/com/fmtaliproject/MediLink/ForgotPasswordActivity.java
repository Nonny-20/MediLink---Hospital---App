package com.fmtaliproject.MediLink;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        // Link the "Back to Login" text to close this screen
        TextView tvBackToLogin = findViewById(R.id.tvBackToLogin);
        tvBackToLogin.setOnClickListener(v -> finish());
    }
}