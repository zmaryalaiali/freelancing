package net.dkr.freelancing.model;

//public class OrderDetailModel {
//}


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class OrderDetailModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("order")
    @Expose
    private Order order;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static class Gig {

        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("customeTitle")
        @Expose
        private String customeTitle;
        @SerializedName("customeDescription")
        @Expose
        private String customeDescription;
        @SerializedName("summery")
        @Expose
        private String summery;
        @SerializedName("startDate")
        @Expose
        private String startDate;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("endDate")
        @Expose
        private String endDate;
        @SerializedName("__v")
        @Expose
        private Integer v;
        @SerializedName("payments")
        @Expose
        private String payments;

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCustomeTitle() {
            return customeTitle;
        }

        public void setCustomeTitle(String customeTitle) {
            this.customeTitle = customeTitle;
        }

        public String getCustomeDescription() {
            return customeDescription;
        }

        public void setCustomeDescription(String customeDescription) {
            this.customeDescription = customeDescription;
        }

        public String getSummery() {
            return summery;
        }

        public void setSummery(String summery) {
            this.summery = summery;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
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

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public Integer getV() {
            return v;
        }

        public void setV(Integer v) {
            this.v = v;
        }

        public String getPayments() {
            return payments;
        }

        public void setPayments(String payments) {
            this.payments = payments;
        }

    }

    public static class Order {

        @SerializedName("orderDelivery")
        @Expose
        private OrderDelivery orderDelivery;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("concepts")
        @Expose
        private Integer concepts;
        @SerializedName("deliveryTime")
        @Expose
        private String deliveryTime;
        @SerializedName("seller")
        @Expose
        private Seller seller;
        @SerializedName("buyer")
        @Expose
        private Buyer buyer;
        @SerializedName("gig")
        @Expose
        private Gig gig;

        public OrderDelivery getOrderDelivery() {
            return orderDelivery;
        }

        public void setOrderDelivery(OrderDelivery orderDelivery) {
            this.orderDelivery = orderDelivery;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Integer getConcepts() {
            return concepts;
        }

        public void setConcepts(Integer concepts) {
            this.concepts = concepts;
        }

        public String getDeliveryTime() {
            return deliveryTime;
        }

        public void setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
        }

        public Seller getSeller() {
            return seller;
        }

        public void setSeller(Seller seller) {
            this.seller = seller;
        }

        public Buyer getBuyer() {
            return buyer;
        }

        public void setBuyer(Buyer buyer) {
            this.buyer = buyer;
        }

        public Gig getGig() {
            return gig;
        }

        public void setGig(Gig gig) {
            this.gig = gig;
        }

    }

    public static class OrderDelivery {

        @SerializedName("data")
        @Expose
        private String data;
        @SerializedName("description")
        @Expose
        private String description;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

    public static class Seller {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("lastname")
        @Expose
        private String lastname;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("isSeller")
        @Expose
        private Boolean isSeller;
        @SerializedName("role")
        @Expose
        private String role;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("__v")
        @Expose
        private Integer v;
        @SerializedName("profile")
        @Expose
        private String profile;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Boolean getIsSeller() {
            return isSeller;
        }

        public void setIsSeller(Boolean isSeller) {
            this.isSeller = isSeller;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
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

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

    }
    public static class Buyer {

        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("lastname")
        @Expose
        private String lastname;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("isSeller")
        @Expose
        private Boolean isSeller;
        @SerializedName("role")
        @Expose
        private String role;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("__v")
        @Expose
        private Integer v;
        @SerializedName("profile")
        @Expose
        private String profile;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Boolean getIsSeller() {
            return isSeller;
        }

        public void setIsSeller(Boolean isSeller) {
            this.isSeller = isSeller;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
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

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

    }


}



