package net.dkr.freelancing.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class RecentModel implements Parcelable{

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
    @SerializedName("reviews")
    @Expose
    private List<Object> reviews;
    @SerializedName("ratingsAverage")
    @Expose
    private Integer ratingsAverage;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("subCategory")
    @Expose
    private String subCategory;
    @SerializedName("attributes")
    @Expose
    private List<Attribute> attributes;
    @SerializedName("options")
    @Expose
    private List<Option> options;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("images")
    @Expose
    private List<Image> images;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("deliveryTime")
    @Expose
    private Integer deliveryTime;
    @SerializedName("concepts")
    @Expose
    private Integer concepts;
    @SerializedName("faqs")
    @Expose
    private List<Faq> faqs;
    @SerializedName("simultaneousProjects")
    @Expose
    private Integer simultaneousProjects;
    @SerializedName("sales")
    @Expose
    private Integer sales;


//    @SerializedName("status")
//    @Expose
//    private Integer status;
//    @SerializedName("_id")
//    @Expose
//    private String id;
//    @SerializedName("title")
//    @Expose
//    private String title;
//    @SerializedName("customeTitle")
//    @Expose
//    private String customeTitle;
//    @SerializedName("summery")
//    @Expose
//    private String summery;
//    @SerializedName("reviews")
//    @Expose
//    private List<Object> reviews;
//    @SerializedName("ratingsAverage")
//    @Expose
//    private Integer ratingsAverage;
//    @SerializedName("category")
//    @Expose
//    private String category;
//    @SerializedName("subCategory")
//    @Expose
//    private String subCategory;
//    @SerializedName("attributes")
//    @Expose
//    private List<Attribute> attributes;
//    @SerializedName("options")
//    @Expose
//    private List<Option> options;
//    @SerializedName("price")
//    @Expose
//    private Integer price;
//    private List<Image> images;
//    @SerializedName("user")
//    @Expose
//    private User user;
//    @SerializedName("deliveryTime")
//    @Expose
//    private Integer deliveryTime;
//    @SerializedName("revisions")
//    @Expose
//    private Integer revisions;
//    @SerializedName("concepts")
//    @Expose
//    private Integer concepts;
//    @SerializedName("features")
//    @Expose
//    private List<Object> features;
//    @SerializedName("sales")
//    @Expose
//    private Integer sales;
//    @SerializedName("createdAt")
//    @Expose
//    private String createdAt;
//    @SerializedName("updatedAt")
//    @Expose
//    private String updatedAt;
//    @SerializedName("__v")
//    @Expose
//    private Integer v;
//    @SerializedName("faqs")
//    @Expose
//    private List<Object> faqs;


    protected RecentModel(Parcel in) {
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readString();
        }
        id = in.readString();
        title = in.readString();
        customeTitle = in.readString();
        customeDescription = in.readString();
        summery = in.readString();
        if (in.readByte() == 0) {
            ratingsAverage = null;
        } else {
            ratingsAverage = in.readInt();
        }
        category = in.readString();
        subCategory = in.readString();
        if (in.readByte() == 0) {
            price = null;
        } else {
            price = in.readInt();
        }
        if (in.readByte() == 0) {
            deliveryTime = null;
        } else {
            deliveryTime = in.readInt();
        }
        if (in.readByte() == 0) {
            concepts = null;
        } else {
            concepts = in.readInt();
        }
        if (in.readByte() == 0) {
            simultaneousProjects = null;
        } else {
            simultaneousProjects = in.readInt();
        }
        if (in.readByte() == 0) {
            sales = null;
        } else {
            sales = in.readInt();
        }
    }

    public static final Creator<RecentModel> CREATOR = new Creator<RecentModel>() {
        @Override
        public RecentModel createFromParcel(Parcel in) {
            return new RecentModel(in);
        }

        @Override
        public RecentModel[] newArray(int size) {
            return new RecentModel[size];
        }
    };

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

    public List<Object> getReviews() {
        return reviews;
    }

    public void setReviews(List<Object> reviews) {
        this.reviews = reviews;
    }

    public Integer getRatingsAverage() {
        return ratingsAverage;
    }

    public void setRatingsAverage(Integer ratingsAverage) {
        this.ratingsAverage = ratingsAverage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getConcepts() {
        return concepts;
    }

    public void setConcepts(Integer concepts) {
        this.concepts = concepts;
    }

    public List<Faq> getFaqs() {
        return faqs;
    }

    public void setFaqs(List<Faq> faqs) {
        this.faqs = faqs;
    }

    public Integer getSimultaneousProjects() {
        return simultaneousProjects;
    }

    public void setSimultaneousProjects(Integer simultaneousProjects) {
        this.simultaneousProjects = simultaneousProjects;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeString(status);
        }
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(customeTitle);
        dest.writeString(customeDescription);
        dest.writeString(summery);
        if (ratingsAverage == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(ratingsAverage);
        }
        dest.writeString(category);
        dest.writeString(subCategory);
        if (price == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(price);
        }
        if (deliveryTime == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(deliveryTime);
        }
        if (concepts == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(concepts);
        }
        if (simultaneousProjects == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(simultaneousProjects);
        }
        if (sales == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sales);
        }
    }

    public static class Option implements Parcelable{

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("status")
        @Expose
        private boolean status;

        public Option(String name, boolean status) {
            this.name = name;
            this.status = status;
        }


        protected Option(Parcel in) {
            name = in.readString();
            status = in.readByte() != 0;
        }

        public static final Creator<Option> CREATOR = new Creator<Option>() {
            @Override
            public Option createFromParcel(Parcel in) {
                return new Option(in);
            }

            @Override
            public Option[] newArray(int size) {
                return new Option[size];
            }
        };

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean getStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeByte((byte) (status ? 1 : 0));
        }
    }


    public class User implements Serializable {

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
        @SerializedName("country")
        @Expose
        private String country;
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

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
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


    }


    public static class Faq implements Parcelable {

        @SerializedName("question")
        @Expose
        private String question;
        @SerializedName("answer")
        @Expose
        private String answer;
        @SerializedName("_id")
        @Expose
        private String id;

        protected Faq(Parcel in) {
            question = in.readString();
            answer = in.readString();
            id = in.readString();
        }

        public static final Creator<Faq> CREATOR = new Creator<Faq>() {
            @Override
            public Faq createFromParcel(Parcel in) {
                return new Faq(in);
            }

            @Override
            public Faq[] newArray(int size) {
                return new Faq[size];
            }
        };

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeString(question);
            dest.writeString(answer);
            dest.writeString(id);
        }
    }


}


class Attribute {

    @SerializedName("0")
    @Expose
    private String _0;
    @SerializedName("1")
    @Expose
    private String _1;
    @SerializedName("2")
    @Expose
    private String _2;
    @SerializedName("3")
    @Expose
    private String _3;
    @SerializedName("4")
    @Expose
    private String _4;
    @SerializedName("5")
    @Expose
    private String _5;
    @SerializedName("6")
    @Expose
    private String _6;
    @SerializedName("7")
    @Expose
    private String _7;
    @SerializedName("8")
    @Expose
    private String _8;
    @SerializedName("9")
    @Expose
    private String _9;
    @SerializedName("10")
    @Expose
    private String _10;
    @SerializedName("11")
    @Expose
    private String _11;
    @SerializedName("12")
    @Expose
    private String _12;
    @SerializedName("13")
    @Expose
    private String _13;
    @SerializedName("14")
    @Expose
    private String _14;
    @SerializedName("_id")
    @Expose
    private String id;

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public String get9() {
        return _9;
    }

    public void set9(String _9) {
        this._9 = _9;
    }

    public String get10() {
        return _10;
    }

    public void set10(String _10) {
        this._10 = _10;
    }

    public String get11() {
        return _11;
    }

    public void set11(String _11) {
        this._11 = _11;
    }

    public String get12() {
        return _12;
    }

    public void set12(String _12) {
        this._12 = _12;
    }

    public String get13() {
        return _13;
    }

    public void set13(String _13) {
        this._13 = _13;
    }

    public String get14() {
        return _14;
    }

    public void set14(String _14) {
        this._14 = _14;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}



