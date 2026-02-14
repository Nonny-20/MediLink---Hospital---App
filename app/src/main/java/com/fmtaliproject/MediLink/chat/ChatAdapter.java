package com.fmtaliproject.MediLink.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.fmtaliproject.MediLink.R;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_SENT = 1;
    private static final int TYPE_RECEIVED = 2;
    private final List<ChatMessage> messages;

    public ChatAdapter(List<ChatMessage> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        // true = Sent by User (Right), false = Received (Left)
        return messages.get(position).isSentByUser() ? TYPE_SENT : TYPE_RECEIVED;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_SENT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feat_chat_item_right, parent, false);
            return new SentViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feat_chat_item_left, parent, false);
            return new ReceivedViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String msg = messages.get(position).getMessage();
        if (holder instanceof SentViewHolder) {
            ((SentViewHolder) holder).tvMessage.setText(msg);
        } else if (holder instanceof ReceivedViewHolder) {
            ((ReceivedViewHolder) holder).tvMessage.setText(msg);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    // ViewHolder for chat_item_right.xml
    static class SentViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;
        SentViewHolder(View itemView) {
            super(itemView);
            // Ensure chat_item_right.xml has android:id="@+id/tvMessageBody"
            tvMessage = itemView.findViewById(R.id.tvMessageBody);
        }
    }

    // ViewHolder for chat_item_left.xml
    static class ReceivedViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage;
        ReceivedViewHolder(View itemView) {
            super(itemView);
            // Matches your provided XML ID
            tvMessage = itemView.findViewById(R.id.tvMessageBody);
        }
    }
}