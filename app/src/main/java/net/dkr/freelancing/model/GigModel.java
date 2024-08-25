package net.dkr.freelancing.model;

public class GigModel {
    private int gig_image;
    private String rate_tv,reviews;
    private boolean favorite_Imaege;
    private int gig_price;
    private String text;

    public GigModel(int gig_image, String rate_tv, String reviews, boolean favorite_Imaege, int gig_price, String text) {
        this.gig_image = gig_image;
        this.rate_tv = rate_tv;
        this.reviews = reviews;
        this.favorite_Imaege = favorite_Imaege;
        this.gig_price = gig_price;
        this.text = text;
    }

    public int getGig_image() {
        return gig_image;
    }

    public String getRate_tv() {
        return rate_tv;
    }

    public String getReviews() {
        return reviews;
    }

    public boolean isFavorite_Imaege() {
        return favorite_Imaege;
    }

    public int getGig_price() {
        return gig_price;
    }

    public String getText() {
        return text;
    }
}
