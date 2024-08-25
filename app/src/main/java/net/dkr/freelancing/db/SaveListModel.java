package net.dkr.freelancing.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "saveListGIg",indices = {@Index(value ={"gigId"},unique = true)})
//@Entity()
public class SaveListModel {
    private byte [] image;
    private String gigName;

   @NonNull
   @PrimaryKey
    private String gigId;
    private String userId; private String subCategoryId;


    public SaveListModel(byte[] image, String gigName, String gigId, String userId, String subCategoryId) {
        this.image = image;
        this.gigName = gigName;
        this.gigId = gigId;
        this.userId = userId;
        this.subCategoryId = subCategoryId;
    }

    public String getUserId() {
        return userId;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public byte[] getImage() {
        return image;
    }

    public String getGigName() {
        return gigName;
    }

    public String getGigId() {
        return gigId;
    }
}
