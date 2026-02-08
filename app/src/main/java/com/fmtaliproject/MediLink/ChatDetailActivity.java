package com.fmtaliproject.MediLink;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ChatDetailActivity extends AppCompatActivity {

    private TextView tvChatPartnerName, tvChatStatus;
    private EditText etMessage;
    private FloatingActionButton btnSend;
    private ImageView btnBack;

    private RecyclerView rvMessages;
    private MessageAdapter adapter;
    private List<String> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        // 1. Initialize UI Elements
        tvChatPartnerName = findViewById(R.id.tvChatPartnerName);
        tvChatStatus = findViewById(R.id.tvChatStatus);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        btnBack = findViewById(R.id.btnBackDetail);
        rvMessages = findViewById(R.id.rvMessages);

        // 2. Setup Header based on who we are chatting with
        String chatType = getIntent().getStringExtra("CHAT_TYPE");
        if (chatType != null) {
            if (chatType.equals("AI")) {
                tvChatPartnerName.setText("AI Health Assistant");
                tvChatStatus.setText("Online • 24/7 Support");
            } else {
                tvChatPartnerName.setText("Dr. Sarah Johnson");
                tvChatStatus.setText("Active Now");
            }
        }

        // 3. Setup RecyclerView
        messageList = new ArrayList<>();
        // Initial Greeting
        messageList.add("Hello! I'm your MediLink assistant.");
        messageList.add("How can I help you today?");

        adapter = new MessageAdapter(messageList);
        rvMessages.setLayoutManager(new LinearLayoutManager(this));
        rvMessages.setAdapter(adapter);

        // 4. Back Button Logic
        btnBack.setOnClickListener(v -> finish());

        // 5. Send Message Logic
        btnSend.setOnClickListener(v -> {
            String text = etMessage.getText().toString().trim();
            if (!TextUtils.isEmpty(text)) {
                sendMessage(text);
                // Simulate an AI response after 1.5 seconds
                simulateResponse(chatType);
            } else {
                Toast.makeText(this, "Type a message first", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendMessage(String text) {
        messageList.add(text);
        adapter.notifyItemInserted(messageList.size() - 1);
        rvMessages.scrollToPosition(messageList.size() - 1);
        etMessage.setText("");
    }

    private void simulateResponse(String chatType) {
        // Change status to show the "user" is typing
        tvChatStatus.setText("typing...");

        new Handler().postDelayed(() -> {
            String response;
            if ("AI".equals(chatType)) {
                response = "I understand. Please tell me more about your symptoms so I can assist you better.";
                tvChatStatus.setText("Online • 24/7 Support");
            } else {
                response = "Thank you for the update. I will review your file and get back to you shortly.";
                tvChatStatus.setText("Active Now");
            }

            messageList.add(response);
            adapter.notifyItemInserted(messageList.size() - 1);
            rvMessages.scrollToPosition(messageList.size() - 1);

        }, 1500); // 1.5 second delay
    }
}