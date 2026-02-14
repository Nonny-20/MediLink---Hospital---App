package com.fmtaliproject.MediLink.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.fmtaliproject.MediLink.R;

public class SignupActivity extends AppCompatActivity {

    private ViewFlipper signupFlipper;
    private Button btnNext;
    private TextView tvStepCounter, tvBack;
    private View bar1, bar2, bar3, bar4;
    private int currentStep = 1;

    // Input Fields for Validation
    private EditText etFirstName, etSurname, etIDNumber, etEmail, etPhone, etPassword, etConfirmPassword;
    private Spinner spinnerGender;
    private CheckBox cbMedicalAid;
    private EditText etMedicalProvider, etMedicalNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_signup);

        // Initialize UI Views
        signupFlipper = findViewById(R.id.signupFlipper);
        btnNext = findViewById(R.id.btnNext);
        tvStepCounter = findViewById(R.id.tvStepCounter);
        tvBack = findViewById(R.id.tvBack);
        bar1 = findViewById(R.id.bar1);
        bar2 = findViewById(R.id.bar2);
        bar3 = findViewById(R.id.bar3);
        bar4 = findViewById(R.id.bar4);

        // Initialize Input Fields
        etFirstName = findViewById(R.id.etFirstName);
        etSurname = findViewById(R.id.etSurname);
        etIDNumber = findViewById(R.id.etIDNumber);
        spinnerGender = findViewById(R.id.spinnerGender);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);

        // Medical Aid Toggle Views
        cbMedicalAid = findViewById(R.id.cbMedicalAid);
        etMedicalProvider = findViewById(R.id.etMedicalProvider);
        etMedicalNumber = findViewById(R.id.etMedicalNumber);

        // --- 1. MEDICAL AID TOGGLE LOGIC ---
        cbMedicalAid.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                etMedicalProvider.setVisibility(View.VISIBLE);
                etMedicalNumber.setVisibility(View.VISIBLE);
            } else {
                etMedicalProvider.setVisibility(View.GONE);
                etMedicalNumber.setVisibility(View.GONE);
                etMedicalProvider.setText(""); // Clear text if unchecked
                etMedicalNumber.setText("");
            }
        });

        // --- 2. NEXT / REGISTER BUTTON LOGIC ---
        btnNext.setOnClickListener(v -> {
            if (validateCurrentStep()) {
                if (currentStep < 4) {
                    goToNextStep();
                } else {
                    finishRegistration();
                }
            }
        });

        tvBack.setOnClickListener(v -> {
            if (currentStep > 1) {
                goToPreviousStep();
            } else {
                finish();
            }
        });
    }

    // --- 3. INPUT VALIDATION LOGIC ---
    private boolean validateCurrentStep() {
        switch (currentStep) {
            case 1: // Personal Info
                if (etFirstName.getText().toString().trim().isEmpty() ||
                        etSurname.getText().toString().trim().isEmpty() ||
                        etIDNumber.getText().toString().trim().isEmpty()) {
                    showToast("Please fill in all personal details");
                    return false;
                }
                if (spinnerGender.getSelectedItemPosition() == 0) {
                    showToast("Please select your gender");
                    return false;
                }
                return true;

            case 2: // Contact
                if (etEmail.getText().toString().trim().isEmpty() ||
                        etPhone.getText().toString().trim().isEmpty()) {
                    showToast("Contact details are required");
                    return false;
                }
                return true;

            case 3: // Medical Info
                if (cbMedicalAid.isChecked()) {
                    if (etMedicalProvider.getText().toString().trim().isEmpty() ||
                            etMedicalNumber.getText().toString().trim().isEmpty()) {
                        showToast("Please enter your medical aid details");
                        return false;
                    }
                }
                return true;

            case 4: // Login Details
                String pass = etPassword.getText().toString();
                String confirm = etConfirmPassword.getText().toString();
                if (pass.isEmpty() || pass.length() < 6) {
                    showToast("Password must be at least 6 characters");
                    return false;
                }
                if (!pass.equals(confirm)) {
                    showToast("Passwords do not match");
                    return false;
                }
                return true;

            default:
                return true;
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void goToNextStep() {
        currentStep++;
        signupFlipper.showNext();
        updateUI();
    }

    private void goToPreviousStep() {
        currentStep--;
        signupFlipper.showPrevious();
        updateUI();
    }

    private void updateUI() {
        tvStepCounter.setText("Step " + currentStep + " of 4");
        btnNext.setText(currentStep == 4 ? "Register" : "Next");

        int teal = ContextCompat.getColor(this, R.color.ml_teal_accent);
        int gray = ContextCompat.getColor(this, R.color.gray_border);

        bar2.setBackgroundColor(currentStep >= 2 ? teal : gray);
        bar3.setBackgroundColor(currentStep >= 3 ? teal : gray);
        bar4.setBackgroundColor(currentStep >= 4 ? teal : gray);
    }

    private void finishRegistration() {
        Toast.makeText(this, "Registration Complete! Please Login.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}