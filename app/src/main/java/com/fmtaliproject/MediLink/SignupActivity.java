package com.fmtaliproject.MediLink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private ViewFlipper signupFlipper;
    private TextView tvStepCounter;
    private View bar1, bar2, bar3, bar4;
    private Button btnNext;
    private int currentStep = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize UI Elements
        signupFlipper = findViewById(R.id.signupFlipper);
        tvStepCounter = findViewById(R.id.tvStepCounter);
        btnNext = findViewById(R.id.btnNext);

        // Progress Bars
        bar1 = findViewById(R.id.bar1);
        bar2 = findViewById(R.id.bar2);
        bar3 = findViewById(R.id.bar3);
        bar4 = findViewById(R.id.bar4);

        // Step 1 - Back Button Logic
        TextView tvBack = findViewById(R.id.tvBack);
        tvBack.setOnClickListener(v -> {
            if (currentStep > 1) {
                goPreviousStep();
            } else {
                finish(); // Close activity if on first step
            }
        });

        // Step 3 - Medical Aid Toggle Logic
        CheckBox cbMedicalAid = findViewById(R.id.cbMedicalAid);
        EditText etMedicalProvider = findViewById(R.id.etMedicalProvider);
        EditText etMedicalNumber = findViewById(R.id.etMedicalNumber);

        cbMedicalAid.setOnCheckedChangeListener((buttonView, isChecked) -> {
            int visibility = isChecked ? View.VISIBLE : View.GONE;
            etMedicalProvider.setVisibility(visibility);
            etMedicalNumber.setVisibility(visibility);
        });

        // Next Button Click Logic
        btnNext.setOnClickListener(v -> {
            if (currentStep < 4) {
                goNextStep();
            } else {
                // Final Step: Complete Registration
                performSignup();
            }
        });
    }

    private void goNextStep() {
        currentStep++;
        signupFlipper.showNext();
        updateUI();
    }

    private void goPreviousStep() {
        currentStep--;
        signupFlipper.showPrevious();
        updateUI();
    }

    private void updateUI() {
        // Update Step Text
        tvStepCounter.setText("Step " + currentStep + " of 4");

        // Update Button Text on last step
        if (currentStep == 4) {
            btnNext.setText("Create Account");
        } else {
            btnNext.setText("Next");
        }

        // Update Progress Bar Colors
        int activeColor = getResources().getColor(R.color.ml_blue);
        int inactiveColor = getResources().getColor(R.color.ml_gray);

        bar2.setBackgroundColor(currentStep >= 2 ? activeColor : inactiveColor);
        bar3.setBackgroundColor(currentStep >= 3 ? activeColor : inactiveColor);
        bar4.setBackgroundColor(currentStep >= 4 ? activeColor : inactiveColor);
    }

    private void performSignup() {
        // Here you would normally save to Firebase or a database
        Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}