package com.fmtaliproject.MediLink.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import com.fmtaliproject.MediLink.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // 1. Back Button Functionality
        ImageView btnBack = findViewById(R.id.btnBackSettings);
        btnBack.setOnClickListener(v -> finish());

        // 2. Language Selection
        findViewById(R.id.layoutLanguage).setOnClickListener(v -> showLanguageDialog());

        // 3. Theme Selection
        findViewById(R.id.layoutTheme).setOnClickListener(v -> showThemeDialog());

        // 4. Notification Settings
        findViewById(R.id.layoutNotifications).setOnClickListener(v -> showNotificationDialog());

        // 5. Privacy & Security
        findViewById(R.id.layoutPrivacy).setOnClickListener(v -> showPrivacyDialog());

        // 6. Help & Support
        findViewById(R.id.layoutHelp).setOnClickListener(v -> showHelpDialog());

        // 7. About Us
        findViewById(R.id.layoutAbout).setOnClickListener(v -> showAboutDialog());

        // 8. Terms & Conditions
        findViewById(R.id.layoutTerms).setOnClickListener(v -> showTermsDialog());

        // 9. Log Out Functionality (Updated to CardView with Confirmation)
        CardView btnLogOut = findViewById(R.id.btnLogOut);
        btnLogOut.setOnClickListener(v -> showLogoutConfirmation());
    }

    private void showLanguageDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_language_selector, null);
        dialog.setContentView(view);
        view.findViewById(R.id.btnCloseDialog).setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showThemeDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_theme_selector, null);
        dialog.setContentView(view);

        view.findViewById(R.id.btnDarkMode).setOnClickListener(v -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            dialog.dismiss();
        });

        view.findViewById(R.id.btnLightMode).setOnClickListener(v -> {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            dialog.dismiss();
        });
        dialog.show();
    }

    private void showNotificationDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_notifications, null);
        dialog.setContentView(view);
        view.findViewById(R.id.btnCloseNotifDialog).setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showPrivacyDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_privacy_security, null);
        dialog.setContentView(view);
        view.findViewById(R.id.btnClosePrivacyDialog).setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showHelpDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_help_support, null);
        dialog.setContentView(view);

        view.findViewById(R.id.btnCloseHelpDialog).setOnClickListener(v -> dialog.dismiss());

        // Example: Dialing the support number
        view.findViewById(R.id.btnCallSupport).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+27111234567"));
            startActivity(intent);
        });
        dialog.show();
    }

    private void showAboutDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_about_us, null);
        dialog.setContentView(view);
        view.findViewById(R.id.btnCloseAbout).setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showTermsDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_terms_conditions, null);
        dialog.setContentView(view);
        view.findViewById(R.id.btnCloseTerms).setOnClickListener(v -> dialog.dismiss());
        dialog.show();
    }

    private void showLogoutConfirmation() {
        // Create a professional alert dialog
        new AlertDialog.Builder(this)
                .setTitle("Log Out")
                .setMessage("Are you sure you want to log out of MediLink?")
                .setCancelable(true)
                .setPositiveButton("Logout", (dialog, which) -> {
                    // 1. Show a quick confirmation message
                    Toast.makeText(SettingsActivity.this, "Successfully logged out", Toast.LENGTH_SHORT).show();

                    // 2. Intent to go back to MainActivity (or LoginActivity)
                    Intent intent = new Intent(SettingsActivity.this, MainActivity.class);

                    // 3. IMPORTANT: Clear the activity stack
                    // This prevents the user from pressing 'Back' to return to Settings
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(intent);
                    finish(); // Close the SettingsActivity
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // Just close the dialog and do nothing
                    dialog.dismiss();
                })
                .show();
    }
}