package net.dkr.freelancing.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class MessageUserModel implements Parcelable {
    private int userImage;
    private String userName;
    private String userId;
    private String date;

    public MessageUserModel(int userImage, String userName, String userId, String date) {
        this.userImage = userImage;
        this.userName = userName;
        this.userId = userId;
        this.date = date;
    }

    protected MessageUserModel(Parcel in) {
        userImage = in.readInt();
        userName = in.readString();
        userId = in.readString();
        date = in.readString();
    }

    public static final Creator<MessageUserModel> CREATOR = new Creator<MessageUserModel>() {
        @Override
        public MessageUserModel createFromParcel(Parcel in) {
            return new MessageUserModel(in);
        }

        @Override
        public MessageUserModel[] newArray(int size) {
            return new MessageUserModel[size];
        }
    };

    public int getUserImage() {
        return userImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(userImage);
        dest.writeString(userName);
        dest.writeString(userId);
        dest.writeString(date);
    }
}
