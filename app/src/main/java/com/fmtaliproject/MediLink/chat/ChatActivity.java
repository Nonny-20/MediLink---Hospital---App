package com.fmtaliproject.MediLink.chat;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.fmtaliproject.MediLink.R;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // 1. Back Button Logic
        ImageView btnBack = findViewById(R.id.btnBackChat);
        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        // 2. AI Assistant Navigation
        CardView cardAI = findViewById(R.id.cardAIAssistant);
        if (cardAI != null) {
            cardAI.setOnClickListener(v -> {
                // For now, showing a message. Later, link to your AI Activity.
                Toast.makeText(this, "Opening AI Assistant...", Toast.LENGTH_SHORT).show();
                // startActivity(new Intent(this, AIAssistantActivity.class));
            });
        }

        // 3. Doctor Messaging Navigation
        CardView cardDoctor = findViewById(R.id.cardDoctorChat);
        if (cardDoctor != null) {
            cardDoctor.setOnClickListener(v -> {
                Toast.makeText(this, "Connecting to your Doctor...", Toast.LENGTH_SHORT).show();
            });
        }

        // 4. Recent Conversation (Dr. Sarah Johnson)
        // Note: In a real app, you'd use a RecyclerView here.
        // For your presentation, you can just set a click listener on the RelativeLayout.
    }
}