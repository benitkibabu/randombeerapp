package com.example.benitkibabu.randombeerapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Benit Kibabu on 23/05/2017.
 */

public class Beer {
    @SerializedName("name")
    String name;
    @SerializedName("description")
    String description;
    @SerializedName("labels")
    Labels label;

    public Beer(String name, String description, Labels label) {
        this.name = name;
        this.description = description;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Labels getLabel() {
        return label;
    }
}
