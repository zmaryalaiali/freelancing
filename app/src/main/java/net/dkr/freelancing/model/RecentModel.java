package net.dkr.freelancing.model;

public class RecentModel {
    private int iamge;
    private int profileImage;
    private String mainText;

    public RecentModel(int iamge, int profileImage, String mainText) {
        this.iamge = iamge;
        this.profileImage = profileImage;
        this.mainText = mainText;
    }

    public int getIamge() {
        return iamge;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getMainText() {
        return mainText;
    }
}
