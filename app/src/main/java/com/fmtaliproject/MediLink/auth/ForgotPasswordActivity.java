package com.fmtaliproject.MediLink.auth;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.fmtaliproject.MediLink.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private RadioGroup rgResetOptions;
    private LinearLayout inputSection;
    private TextView tvInputLabel;
    private EditText etResetInput;
    private Button btnSendReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_forgot_password);

        // 1. Initialize UI Elements
        rgResetOptions = findViewById(R.id.rgResetOptions);
        inputSection = findViewById(R.id.inputSection);
        tvInputLabel = findViewById(R.id.tvInputLabel);
        etResetInput = findViewById(R.id.etResetInput);
        btnSendReset = findViewById(R.id.btnSendReset);
        TextView tvBackToLogin = findViewById(R.id.tvBackToLogin);

        // 2. Logic to Show/Hide Input based on Radio Selection
        rgResetOptions.setOnCheckedChangeListener((group, checkedId) -> {
            // Make the input section visible once a choice is made
            inputSection.setVisibility(View.VISIBLE);

            if (checkedId == R.id.rbEmail) {
                tvInputLabel.setText("Email Address");
                etResetInput.setHint("example@mail.com");
                etResetInput.setInputType(android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
            } else if (checkedId == R.id.rbPhone) {
                tvInputLabel.setText("Phone Number");
                etResetInput.setHint("+27 12 345 6789");
                etResetInput.setInputType(android.text.InputType.TYPE_CLASS_PHONE);
            }
        });

        // 3. Send Button Logic
        btnSendReset.setOnClickListener(v -> {
            String input = etResetInput.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter your details", Toast.LENGTH_SHORT).show();
            } else {
                // For demo purposes, just show a success message
                Toast.makeText(this, "Reset link sent to " + input, Toast.LENGTH_LONG).show();
                finish(); // Go back to login after sending
            }
        });

        // 4. Back Button Logic
        tvBackToLogin.setOnClickListener(v -> finish());
    }
}