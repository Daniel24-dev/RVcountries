package com.example.rvcountries;

import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private String imageUrl;

    public City(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
