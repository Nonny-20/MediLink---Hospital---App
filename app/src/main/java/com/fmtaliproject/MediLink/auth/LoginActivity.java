package com.fmtaliproject.MediLink.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.R;
import com.fmtaliproject.MediLink.activities.MainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 1. INITIALIZE variables by linking them to XML IDs
        // Note: We use R.id.btnForgot because that is what is in your XML
        TextView btnBack = findViewById(R.id.btnBack);
        EditText etPatientId = findViewById(R.id.etPatientId);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnSubmit = findViewById(R.id.btnSubmitLogin);
        TextView tvForgot = findViewById(R.id.btnForgot);

        // 2. Handle Login Logic
        btnSubmit.setOnClickListener(v -> {
            String id = etPatientId.getText().toString().trim();
            String pass = etPassword.getText().toString();

            if (id.equals("ML-12345") && pass.equals("Pass123!")) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid ID or Password", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. Handle Navigation
        tvForgot.setOnClickListener(v ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));

        btnBack.setOnClickListener(v -> finish());
    }
}