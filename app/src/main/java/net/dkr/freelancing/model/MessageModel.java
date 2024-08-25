package net.dkr.freelancing.model;

public class MessageModel {

    public static String SENT_ME = "me";
    public static  String SENT_BY = "server";
    private String message;
    private String sentBy;

    private String date;

    public MessageModel(String message, String sentBy, String date) {
        this.message = message;
        this.sentBy = sentBy;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public String getSentBy() {
        return sentBy;
    }

    public String getDate() {
        return date;
    }
}
