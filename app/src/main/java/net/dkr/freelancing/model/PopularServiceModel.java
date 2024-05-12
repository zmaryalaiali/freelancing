package net.dkr.freelancing.model;

public class PopularServiceModel {
    private int image;
    private String text;

    public PopularServiceModel(int image, String text) {
        this.image = image;
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
