package com.fmtaliproject.MediLink.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.fmtaliproject.MediLink.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity {

    private CardView cardGP, cardSpecialist, cardTherapist;
    private View btnBack;
    private String selectedMode = "In-Person"; // Tracks Virtual vs In-Person

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feat_booking);

        // 1. Initialize the selection screen buttons
        btnBack = findViewById(R.id.btnBack);
        cardGP = findViewById(R.id.cardGP);
        cardSpecialist = findViewById(R.id.cardSpecialist);
        cardTherapist = findViewById(R.id.cardTherapist);

        // 2. Make the Back Button work
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 3. Make each "Type" card open the Booking Form
        if (cardGP != null) cardGP.setOnClickListener(v -> openBookingForm("General Practitioner"));
        if (cardSpecialist != null) cardSpecialist.setOnClickListener(v -> openBookingForm("Specialist"));
        if (cardTherapist != null) cardTherapist.setOnClickListener(v -> openBookingForm("Therapist"));
    }

    private void openBookingForm(String professionalType) {
        // Create the Bottom Sheet Dialog (This is your feat_booking_form)
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.feat_booking_form, null);
        dialog.setContentView(sheetView);

        // 4. Initialize buttons INSIDE the form (feat_booking_form.xml)
        CardView cardInPerson = sheetView.findViewById(R.id.cardInPerson);
        CardView cardVirtual = sheetView.findViewById(R.id.cardVirtual);
        EditText etDate = sheetView.findViewById(R.id.etDate);
        EditText etReason = sheetView.findViewById(R.id.etReason);
        Button btnSubmit = sheetView.findViewById(R.id.btnSubmit);

        // Logic for selecting In-Person vs Virtual
        if (cardInPerson != null && cardVirtual != null) {
            cardInPerson.setOnClickListener(v -> {
                selectedMode = "In-Person";
                cardInPerson.setCardBackgroundColor(ContextCompat.getColor(this, R.color.ml_teal_accent));
                cardVirtual.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            });

            cardVirtual.setOnClickListener(v -> {
                selectedMode = "Virtual";
                cardVirtual.setCardBackgroundColor(ContextCompat.getColor(this, R.color.ml_teal_accent));
                cardInPerson.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white));
            });
        }

        // 5. Make the Date Picker work
        if (etDate != null) {
            etDate.setOnClickListener(v -> {
                Calendar cal = Calendar.getInstance();
                new DatePickerDialog(this, (view, year, month, day) -> {
                    String date = String.format(Locale.getDefault(), "%02d/%02d/%d", day, month + 1, year);
                    etDate.setText(date);
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();
            });
        }

        // 6. Updated Submission: Transition to Confirmation Screen
        if (btnSubmit != null) {
            btnSubmit.setOnClickListener(v -> {
                String dateText = etDate.getText().toString();
                String reasonText = etReason.getText().toString().trim();

                if (dateText.isEmpty()) {
                    Toast.makeText(this, "Please select a date first!", Toast.LENGTH_SHORT).show();
                } else {
                    // Create Intent to go to auth_confirm_details
                    Intent intent = new Intent(this, ConfirmDetailsActivity.class);

                    // Bundle the sensitive data to pass to the next activity
                    intent.putExtra("EXTRA_TYPE", professionalType);
                    intent.putExtra("EXTRA_MODE", selectedMode);
                    intent.putExtra("EXTRA_DATE", dateText);
                    intent.putExtra("EXTRA_REASON", reasonText);

                    startActivity(intent);
                    dialog.dismiss(); // Close the bottom sheet
                }
            });
        }

        dialog.show();
    }
}