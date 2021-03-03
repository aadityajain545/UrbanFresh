package com.test.uebanfresh.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeScreenApiModel  {
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("components")
    @Expose
    private List<ComponentModel> components = null;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ComponentModel> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentModel> components) {
        this.components = components;
    }
}
