package com.example.benitkibabu.randombeerapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Benit Kibabu on 23/05/2017.
 */

public class Labels {
    @SerializedName("icon")
    String icon;
    @SerializedName("medium")
    String medium;
    @SerializedName("large")
    String large;

    public Labels(){}

    public Labels(String icon, String medium, String large) {
        this.icon = icon;
        this.medium = medium;
        this.large = large;
    }

    public String getIcon() {
        return icon;
    }

    public String getMedium() {
        return medium;
    }

    public String getLarge() {
        return large;
    }
}
