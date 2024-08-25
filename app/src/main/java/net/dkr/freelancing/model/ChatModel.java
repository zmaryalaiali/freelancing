package net.dkr.freelancing.model;

public class ChatModel {
    private String sender;
    private String reciever;

    public ChatModel(String sender, String reciever) {
        this.sender = sender;
        this.reciever = reciever;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }
}
