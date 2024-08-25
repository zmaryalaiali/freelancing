package net.dkr.freelancing.model;

public class ChatResponse {

    String [] members;
    String _id;
    private String createdAt;
    private String updatedAt;

    public String[] getMembers() {
        return members;
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
