package com.example.benitkibabu.randombeerapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Benit Kibabu on 23/05/2017.
 */

public class SearchResult {
    @SerializedName("message")
    String message;
    @SerializedName("data")
    Beer data;
    @SerializedName("status")
    String status;

    public SearchResult(String message, Beer data, String status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Beer getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
