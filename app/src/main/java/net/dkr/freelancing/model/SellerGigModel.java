package net.dkr.freelancing.model;

public class SellerGigModel {
    private String sellerGigStatus;

    private String sellerGigText;
    private int sellerGigImage;
    private String sellerGigPrice;

    public SellerGigModel(String sellerGigStatus, String sellerGigText, int sellerGigImage, String sellerGigPrice) {
        this.sellerGigStatus = sellerGigStatus;
        this.sellerGigText = sellerGigText;
        this.sellerGigImage = sellerGigImage;
        this.sellerGigPrice = sellerGigPrice;
    }

    public String getSellerGigStatus() {
        return sellerGigStatus;
    }

    public String getSellerGigText() {
        return sellerGigText;
    }

    public int getSellerGigImage() {
        return sellerGigImage;
    }

    public String getSellerGigPrice() {
        return sellerGigPrice;
    }
}
