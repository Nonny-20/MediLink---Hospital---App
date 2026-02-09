package com.fmtaliproject.MediLink.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fmtaliproject.MediLink.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<String> messages;
    private static final int TYPE_LEFT = 0;  // For AI/Doctor
    private static final int TYPE_RIGHT = 1; // For User (You)

    public MessageAdapter(List<String> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        // Simple logic for the demo:
        // Even-indexed messages are Left (AI), Odd-indexed are Right (User)
        return (position % 2 == 0) ? TYPE_LEFT : TYPE_RIGHT;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_LEFT) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_left, parent, false);
            return new LeftViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_right, parent, false);
            return new RightViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String messageContent = messages.get(position);

        if (holder instanceof LeftViewHolder) {
            ((LeftViewHolder) holder).tvMessageBody.setText(messageContent);
        } else if (holder instanceof RightViewHolder) {
            ((RightViewHolder) holder).tvMessageBody.setText(messageContent);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    // ViewHolder for the Left (AI/Doctor) bubble
    static class LeftViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessageBody;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessageBody = itemView.findViewById(R.id.tvMessageBody);
        }
    }

    // ViewHolder for the Right (User) bubble
    static class RightViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessageBody;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessageBody = itemView.findViewById(R.id.tvMessageBody);
        }
    }
}