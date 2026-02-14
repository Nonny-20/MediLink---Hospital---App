package com.fmtaliproject.MediLink.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.R;
import com.fmtaliproject.MediLink.activities.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_login);

        // 1. Initialize variables by linking them to XML IDs
        TextView btnBack = findViewById(R.id.btnBack);
        EditText etPatientId = findViewById(R.id.etPatientId);
        EditText etPassword = findViewById(R.id.etPassword);
        Button btnSubmit = findViewById(R.id.btnSubmitLogin);
        TextView tvForgot = findViewById(R.id.btnForgot);

        // 2. Handle Login Logic
        btnSubmit.setOnClickListener(v -> {
            String id = etPatientId.getText().toString().trim();
            String pass = etPassword.getText().toString();

            // Simple validation: Check if fields are not empty
            if (!id.isEmpty() && !pass.isEmpty()) {
                // SUCCESS: Redirect to HomeActivity
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);

                // Close LoginActivity so user cannot "back" into it
                finish();
            } else {
                Toast.makeText(this, "Please enter your ID and Password", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. Handle Navigation to Forgot Password
        if (tvForgot != null) {
            tvForgot.setOnClickListener(v ->
                    startActivity(new Intent(this, ForgotPasswordActivity.class)));
        }

        // 4. Handle Back Button (takes user back to Welcome screen)
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }
    }
}