package com.test.uebanfresh.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdsBannerModel {
    @SerializedName("banner_id")
    @Expose
    private int bannerId;
    @SerializedName("banner_name")
    @Expose
    private String bannerName;
    @SerializedName("banner_description")
    @Expose
    private String bannerDescription;
    @SerializedName("banner_alt")
    @Expose
    private String bannerAlt;
    @SerializedName("banner_image")
    @Expose
    private String bannerImage;
    @SerializedName("url_type")
    @Expose
    private String urlType;
    @SerializedName("url_id")
    @Expose
    private int urlId;

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerDescription() {
        return bannerDescription;
    }

    public void setBannerDescription(String bannerDescription) {
        this.bannerDescription = bannerDescription;
    }

    public String getBannerAlt() {
        return bannerAlt;
    }

    public void setBannerAlt(String bannerAlt) {
        this.bannerAlt = bannerAlt;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }

    public String getUrlType() {
        return urlType;
    }

    public void setUrlType(String urlType) {
        this.urlType = urlType;
    }

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

}
