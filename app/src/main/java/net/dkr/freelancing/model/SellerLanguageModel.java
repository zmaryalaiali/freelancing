package net.dkr.freelancing.model;

public class SellerLanguageModel {
    private String languageName;
    private String languageDesc;


    public SellerLanguageModel(String languageName, String languageDesc) {
        this.languageName = languageName;
        this.languageDesc = languageDesc;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getLanguageDesc() {
        return languageDesc;
    }
}
