package net.dkr.freelancing.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SubmitProposalModel {

    @SerializedName("coverLetter")
    @Expose
    private String coverLetter;
    @SerializedName("images")
    @Expose
    private List<Image> images;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("job")
    @Expose
    private String job;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }


    public static class Data {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("data")
        @Expose
        private List<Integer> data;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Integer> getData() {
            return data;
        }

        public void setData(List<Integer> data) {
            this.data = data;
        }

    }
    public static class Image {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("img")
        @Expose
        private net.dkr.freelancing.model.Img img;
        @SerializedName("_id")
        @Expose
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public net.dkr.freelancing.model.Img getImg() {
            return img;
        }

        public void setImg(net.dkr.freelancing.model.Img img) {
            this.img = img;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }
    public static class Img {

        @SerializedName("data")
        @Expose
        private net.dkr.freelancing.model.Data data;
        @SerializedName("contentType")
        @Expose
        private String contentType;

        public net.dkr.freelancing.model.Data getData() {
            return data;
        }

        public void setData(net.dkr.freelancing.model.Data data) {
            this.data = data;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

    }

}

