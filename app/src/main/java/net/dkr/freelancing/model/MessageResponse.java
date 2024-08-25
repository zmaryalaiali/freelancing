package net.dkr.freelancing.model;

public class MessageResponse {
    private String chat;
    private String sender;

    private String text;
    private String _id;

    private String createdAt;
    private String updatedAt;

    public String getChat() {
        return chat;
    }

    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public String get_id() {
        return _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
