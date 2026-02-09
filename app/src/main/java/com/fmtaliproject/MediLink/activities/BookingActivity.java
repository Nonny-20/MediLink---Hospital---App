package com.fmtaliproject.MediLink.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.fmtaliproject.MediLink.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    private CardView cardGP, cardSpecialist, cardTherapist, btnBack;
    private TextView txtGetAI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        // 1. Initialize Main Screen Views
        btnBack = findViewById(R.id.btnBack);
        cardGP = findViewById(R.id.cardGP);
        cardSpecialist = findViewById(R.id.cardSpecialist);
        cardTherapist = findViewById(R.id.cardTherapist);
        txtGetAI = findViewById(R.id.txtGetAI);

        // 2. Back Button
        btnBack.setOnClickListener(v -> finish());

        // 3. AI Recommendation Click
        txtGetAI.setOnClickListener(v ->
                Toast.makeText(this, "AI is analyzing your symptoms...", Toast.LENGTH_LONG).show()
        );

        // 4. Professional Selection Clicks
        cardGP.setOnClickListener(v -> showBookingBottomSheet("General Practitioner"));
        cardSpecialist.setOnClickListener(v -> showBookingBottomSheet("Specialist"));
        cardTherapist.setOnClickListener(v -> showBookingBottomSheet("Therapist / Counselor"));
    }

    private void showBookingBottomSheet(String professionalType) {
        // Create the Bottom Sheet
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.layout_booking_form, null);
        bottomSheetDialog.setContentView(sheetView);

        // Initialize Views INSIDE the Bottom Sheet
        EditText etDate = sheetView.findViewById(R.id.etDate);
        EditText etReason = sheetView.findViewById(R.id.etReason);
        Button btnSubmit = sheetView.findViewById(R.id.btnSubmit);

        // Set up Date Picker for the field inside the sheet
        etDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, day) -> {
                etDate.setText(day + "/" + (month + 1) + "/" + year);
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        // Submit Button Logic
        btnSubmit.setOnClickListener(v -> {
            String date = etDate.getText().toString();
            if (date.isEmpty()) {
                Toast.makeText(this, "Please select a date", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Booking request for " + professionalType + " sent for " + date, Toast.LENGTH_LONG).show();
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.show();
    }
}