package net.dkr.freelancing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchModel {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("categories")
    @Expose
    private Category categories[];

    public SearchModel(String status, Category[] categories) {
        this.status = status;
        this.categories = categories;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }


    public static class Category {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("_id")
        @Expose
        private String _id;
        @SerializedName("subCategories")
        @Expose
        private SubCategory subCategory[];

        public Category(String name, String _id, SubCategory[] subCategory) {
            this.name = name;
            this._id = _id;
            this.subCategory = subCategory;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public SubCategory[] getSubCategory() {
            return subCategory;
        }

        public void setSubCategory(SubCategory[] subCategory) {
            this.subCategory = subCategory;
        }
    }
    public static class SubCategory{
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("_id")
        @Expose
        private String _id;

        public SubCategory(String name, String _id) {
            this.name = name;
            this._id = _id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }
    }
}
