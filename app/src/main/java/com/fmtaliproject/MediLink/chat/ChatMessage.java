package com.fmtaliproject.MediLink.chat;

public class ChatMessage {
    private String message;
    private boolean isSentByUser; // true = Right side (User), false = Left side (Doctor)

    public ChatMessage(String message, boolean isSentByUser) {
        this.message = message;
        this.isSentByUser = isSentByUser;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSentByUser() {
        return isSentByUser;
    }
}