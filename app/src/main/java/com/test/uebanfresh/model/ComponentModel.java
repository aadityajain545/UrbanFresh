package com.test.uebanfresh.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ComponentModel {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("StaticBanner")
    @Expose
    private List<StaticBannerModel> staticBanner = null;
    @SerializedName("categorydata")
    @Expose
    private List<CategoryDataModel> categorydata = null;
    @SerializedName("AdsBanner")
    @Expose
    private List<AdsBannerModel> adsBanner = null;
    @SerializedName("CarouselBanner")
    @Expose
    private List<Object> carouselBanner = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StaticBannerModel> getStaticBanner() {
        return staticBanner;
    }

    public void setStaticBanner(List<StaticBannerModel> staticBanner) {
        this.staticBanner = staticBanner;
    }

    public List<CategoryDataModel> getCategorydata() {
        return categorydata;
    }

    public void setCategorydata(List<CategoryDataModel> categorydata) {
        this.categorydata = categorydata;
    }

    public List<AdsBannerModel> getAdsBanner() {
        return adsBanner;
    }

    public void setAdsBanner(List<AdsBannerModel> adsBanner) {
        this.adsBanner = adsBanner;
    }

    public List<Object> getCarouselBanner() {
        return carouselBanner;
    }

    public void setCarouselBanner(List<Object> carouselBanner) {
        this.carouselBanner = carouselBanner;
    }
}
