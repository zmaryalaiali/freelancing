package net.dkr.freelancing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GigOrderModel {
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("seller")
    @Expose
    public RecentModel.User seller;
    @SerializedName("buyer")
    @Expose
   public RecentModel.User buyer;

//        @SerializedName("gig")
//    @Expose
//    RecentModel gig;
    @SerializedName("status")
    @Expose
    public String status;

    @SerializedName("_id")
    @Expose
    public String _id;

    public String startDate;

//    public static class Seller {
//
//    }
}


