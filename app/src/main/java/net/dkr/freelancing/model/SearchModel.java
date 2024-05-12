package net.dkr.freelancing.model;

public class SearchModel {
    private String categoryName;
    private String categoryDescription;

    private int categoryImage;

    public SearchModel(String categoryName, String categoryDescription, int categoryImage) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public int getCategoryImage() {
        return categoryImage;
    }
}
