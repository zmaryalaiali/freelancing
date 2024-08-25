package net.dkr.freelancing.model;

public class JobCreateModel {
    private String title;
    private String description;
    private String budget;
    private String sellerLevel;
    private String delivery;
    private String buyer;
    private String category;
    private String subCategory;

    public JobCreateModel(String title, String description, String budget, String sellerLevel, String delivery, String buyer, String category, String subCategory) {
        this.title = title;
        this.description = description;
        this.budget = budget;
        this.sellerLevel = sellerLevel;
        this.delivery = delivery;
        this.buyer = buyer;
        this.category = category;
        this.subCategory = subCategory;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBudget() {
        return budget;
    }

    public String getSellerLevel() {
        return sellerLevel;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getBuyer() {
        return buyer;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }
}
