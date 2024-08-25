package net.dkr.freelancing.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class JobBuyerModel  implements Parcelable {

   private String _id;
   private String title;
   private String description;
   private String startDate;
   private String budget;
   private String sellerLevel;
   private String status;
   private Object proposal[];


    protected JobBuyerModel(Parcel in) {
        _id = in.readString();
        title = in.readString();
        description = in.readString();
        startDate = in.readString();
        budget = in.readString();
        sellerLevel = in.readString();
        status = in.readString();
    }

    public static final Creator<JobBuyerModel> CREATOR = new Creator<JobBuyerModel>() {
        @Override
        public JobBuyerModel createFromParcel(Parcel in) {
            return new JobBuyerModel(in);
        }

        @Override
        public JobBuyerModel[] newArray(int size) {
            return new JobBuyerModel[size];
        }
    };

    public String getSellerLevel() {
        return sellerLevel;
    }

    public void setSellerLevel(String sellerLevel) {
        this.sellerLevel = sellerLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public Object[] getProposal() {
        return proposal;
    }

    public void setProposal(Object[] proposal) {
        this.proposal = proposal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(_id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(startDate);
        dest.writeString(budget);
        dest.writeString(sellerLevel);
        dest.writeString(status);
    }
}
