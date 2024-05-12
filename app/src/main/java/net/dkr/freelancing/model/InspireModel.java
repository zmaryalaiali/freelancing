package net.dkr.freelancing.model;

public class InspireModel {
    private int image;
    private int rateImage;
    private int faoriteImaege;

    private String text;

    public InspireModel(int image, int rateImage, int faoriteImaege, String text) {
        this.image = image;
        this.rateImage = rateImage;
        this.faoriteImaege = faoriteImaege;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public int getRateImage() {
        return rateImage;
    }

    public int getFaoriteImaege() {
        return faoriteImaege;
    }

    public String getText() {
        return text;
    }
}
