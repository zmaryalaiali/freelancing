package net.dkr.freelancing.model;

public class CreateOrderPostModel {
    private String gigId;

    public CreateOrderPostModel(String gigId) {
        this.gigId = gigId;
    }

    public String getGigId() {
        return gigId;
    }

    public void setGigId(String gigId) {
        this.gigId = gigId;
    }
}
