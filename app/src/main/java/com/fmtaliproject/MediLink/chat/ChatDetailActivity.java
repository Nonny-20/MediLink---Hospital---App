package com.fmtaliproject.MediLink.chat;

import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.fmtaliproject.MediLink.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class ChatDetailActivity extends AppCompatActivity {

    private RecyclerView rvMessages;
    private ChatAdapter adapter;
    private List<ChatMessage> messageList;
    private EditText etMessage;
    private FloatingActionButton btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ensure this matches your XML file name (e.g., feat_chat_details.xml)
        setContentView(R.layout.feat_chat_detail);

        // 1. Back Button
        CardView btnBack = findViewById(R.id.btnBackDetail);
        if (btnBack != null) btnBack.setOnClickListener(v -> finish());

        // 2. Initialize Views using your new XML IDs
        rvMessages = findViewById(R.id.rvMessages);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        // 3. Setup List & Adapter
        messageList = new ArrayList<>();
        messageList.add(new ChatMessage("Hello! I am your AI assistant. How can I help you today?", false));

        adapter = new ChatAdapter(messageList);
        rvMessages.setLayoutManager(new LinearLayoutManager(this));
        rvMessages.setAdapter(adapter);

        // 4. Send Logic
        btnSend.setOnClickListener(v -> {
            String text = etMessage.getText().toString().trim();
            if (!text.isEmpty()) {
                messageList.add(new ChatMessage(text, true));
                adapter.notifyItemInserted(messageList.size() - 1);
                rvMessages.scrollToPosition(messageList.size() - 1);
                etMessage.setText("");
            }
        });
    }
}