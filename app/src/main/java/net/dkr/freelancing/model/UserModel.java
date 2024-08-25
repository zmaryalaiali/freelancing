package net.dkr.freelancing.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class UserModel {

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
    @SerializedName("profile")
    @Expose
    private Profile profile;

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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public static class WorkExperience {

        @SerializedName("startDate")
        @Expose
        private StartDate startDate;
        @SerializedName("endDate")
        @Expose
        private EndDate endDate;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("company")
        @Expose
        private String company;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("_id")
        @Expose
        private String id;

        public StartDate getStartDate() {
            return startDate;
        }

        public void setStartDate(StartDate startDate) {
            this.startDate = startDate;
        }

        public EndDate getEndDate() {
            return endDate;
        }

        public void setEndDate(EndDate endDate) {
            this.endDate = endDate;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public static class Education {

        @SerializedName("school")
        @Expose
        private String school;
        @SerializedName("degree")
        @Expose
        private String degree;
        @SerializedName("field")
        @Expose
        private String field;
        @SerializedName("from")
        @Expose
        private Integer from;
        @SerializedName("to")
        @Expose
        private Integer to;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("_id")
        @Expose
        private String id;

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getDegree() {
            return degree;
        }

        public void setDegree(String degree) {
            this.degree = degree;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public Integer getFrom() {
            return from;
        }

        public void setFrom(Integer from) {
            this.from = from;
        }

        public Integer getTo() {
            return to;
        }

        public void setTo(Integer to) {
            this.to = to;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public static class EndDate {

        @SerializedName("endMonth")
        @Expose
        private String endMonth;
        @SerializedName("endYear")
        @Expose
        private Integer endYear;

        public String getEndMonth() {
            return endMonth;
        }

        public void setEndMonth(String endMonth) {
            this.endMonth = endMonth;
        }

        public Integer getEndYear() {
            return endYear;
        }

        public void setEndYear(Integer endYear) {
            this.endYear = endYear;
        }

    }

    public static class Language {

        @SerializedName("language")
        @Expose
        private String language;
        @SerializedName("proficiency")
        @Expose
        private String proficiency;
        @SerializedName("_id")
        @Expose
        private String id;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getProficiency() {
            return proficiency;
        }

        public void setProficiency(String proficiency) {
            this.proficiency = proficiency;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public static class Photo {

        @SerializedName("img")
        @Expose
        private Img img;

        public Img getImg() {
            return img;
        }

        public void setImg(Img img) {
            this.img = img;
        }

    }

    public static class StartDate {

        @SerializedName("startMonth")
        @Expose
        private String startMonth;
        @SerializedName("startYear")
        @Expose
        private Integer startYear;

        public String getStartMonth() {
            return startMonth;
        }

        public void setStartMonth(String startMonth) {
            this.startMonth = startMonth;
        }

        public Integer getStartYear() {
            return startYear;
        }

        public void setStartYear(Integer startYear) {
            this.startYear = startYear;
        }

    }

    public static class Profile {

        @SerializedName("photo")
        @Expose
        private Photo photo;
        @SerializedName("communities")
        @Expose
        private List<Object> communities;
        @SerializedName("_id")
        @Expose
        private String id;
        @SerializedName("profileTitle")
        @Expose
        private String profileTitle;
        @SerializedName("level")
        @Expose
        private String level;
        @SerializedName("badges")
        @Expose
        private List<Object> badges;
        @SerializedName("workExperience")
        @Expose
        private List<WorkExperience> workExperience;
        @SerializedName("education")
        @Expose
        private List<Education> education;
        @SerializedName("languages")
        @Expose
        private List<Language> languages;
        @SerializedName("skills")
        @Expose
        private List<String> skills;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("postalCode")
        @Expose
        private Integer postalCode;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("createdAt")
        @Expose
        private String createdAt;
        @SerializedName("updatedAt")
        @Expose
        private String updatedAt;
        @SerializedName("__v")
        @Expose
        private Integer v;

        public Photo getPhoto() {
            return photo;
        }

        public void setPhoto(Photo photo) {
            this.photo = photo;
        }

        public List<Object> getCommunities() {
            return communities;
        }

        public void setCommunities(List<Object> communities) {
            this.communities = communities;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProfileTitle() {
            return profileTitle;
        }

        public void setProfileTitle(String profileTitle) {
            this.profileTitle = profileTitle;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public List<Object> getBadges() {
            return badges;
        }

        public void setBadges(List<Object> badges) {
            this.badges = badges;
        }

        public List<WorkExperience> getWorkExperience() {
            return workExperience;
        }

        public void setWorkExperience(List<WorkExperience> workExperience) {
            this.workExperience = workExperience;
        }

        public List<Education> getEducation() {
            return education;
        }

        public void setEducation(List<Education> education) {
            this.education = education;
        }

        public List<Language> getLanguages() {
            return languages;
        }

        public void setLanguages(List<Language> languages) {
            this.languages = languages;
        }

        public List<String> getSkills() {
            return skills;
        }

        public void setSkills(List<String> skills) {
            this.skills = skills;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Integer getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(Integer postalCode) {
            this.postalCode = postalCode;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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

}





