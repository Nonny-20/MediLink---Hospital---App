package com.fmtaliproject.MediLink;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Back button to return to Welcome Screen
        findViewById(R.id.btnBack).setOnClickListener(v -> finish());

        // Submit button (For now, we just close or move to Home)
        findViewById(R.id.btnSubmitLogin).setOnClickListener(v -> {
            // Add your logic to move to HomeActivity here later
        });
    }
}