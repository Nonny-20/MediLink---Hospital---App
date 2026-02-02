package com.fmtaliproject.MediLink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TEST_PATIENT_ID = "ML-12345";
    private static final String TEST_PASSWORD = "Pass123!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tvForgot = findViewById(R.id.tvForgot);
        tvForgot.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class))
        );

        EditText etPatientId = findViewById(R.id.etPatientId);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnContinue = findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(v -> {
            String patientId = etPatientId.getText().toString().trim();
            String password = etPassword.getText().toString();

            if (patientId.isEmpty()) {
                etPatientId.setError("Patient ID is required");
                etPatientId.requestFocus();
                return;
            }

            if (password.isEmpty()) {
                etPassword.setError("Password is required");
                etPassword.requestFocus();
                return;
            }

            // MOCK AUTH (replace later with Spring Boot call)
            if (TEST_PATIENT_ID.equals(patientId) && TEST_PASSWORD.equals(password)) {

                getSharedPreferences("medilink_prefs", MODE_PRIVATE)
                        .edit()
                        .putString("access_token", "FAKE_TOKEN")
                        .putString("user_id", patientId)
                        .putString("role", "PATIENT")
                        .apply();

                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();

            } else {
                Toast.makeText(MainActivity.this,
                        "Invalid Patient ID or Password",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
