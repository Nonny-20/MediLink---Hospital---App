package com.fmtaliproject.MediLink.chat;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.fmtaliproject.MediLink.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feat_chat_list); // Ensure this matches your XML file name

        // 1. Initialize Views
        CardView btnBack = findViewById(R.id.btnBackChat);
        CardView cardAI = findViewById(R.id.cardAIAssistant);
        CardView cardDoctor = findViewById(R.id.cardDoctorChat);

        // 2. Back Button Logic
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 3. AI Assistant Click
        if (cardAI != null) {
            cardAI.setOnClickListener(v -> {
                // Future: Intent to AIChatActivity
                Toast.makeText(this, "Opening AI Health Assistant...", Toast.LENGTH_SHORT).show();
            });
        }

        // 4. Direct Message Click
        if (cardDoctor != null) {
            cardDoctor.setOnClickListener(v -> {
                // Future: Intent to DoctorListActivity or specific Chat
                Toast.makeText(this, "Connecting to your Doctor...", Toast.LENGTH_SHORT).show();
            });
        }
    }
}