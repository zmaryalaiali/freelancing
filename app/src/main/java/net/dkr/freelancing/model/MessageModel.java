package net.dkr.freelancing.model;

public class MessageModel {

    public static String SENT_ME = "me";
    public static  String SENT_BY = "server";
    private String message;
    private String sentBy;

    public MessageModel(String message, String sentBy) {
        this.message = message;
        this.sentBy = sentBy;
    }

    public String getMessage() {
        return message;
    }

    public String getSentBy() {
        return sentBy;
    }
}
