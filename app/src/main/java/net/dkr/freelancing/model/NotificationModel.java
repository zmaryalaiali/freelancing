package net.dkr.freelancing.model;

public class NotificationModel {
    private String message;
    private String type;
    private String link;
    private String userId;

    public NotificationModel(String message, String type, String link, String userId) {
        this.message = message;
        this.type = type;
        this.link = link;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getLink() {
        return link;
    }

    public String getUserId() {
        return userId;
    }
}
