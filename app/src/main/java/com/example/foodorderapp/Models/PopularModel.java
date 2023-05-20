package com.example.foodorderapp.Models;

import android.content.Intent;

public class PopularModel {
    private Integer image;
    private String title;
    private String description;
    private Double fee;
    private Integer numberInCart;

    public PopularModel(Integer image, String title, String description, Double fee, Integer numberInCart) {
        this.image = image;
        this.title = title;
        this.description = description;
        this.fee = fee;
        this.numberInCart = numberInCart;
    }

    public Integer getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Double getFee() {
        return fee;
    }

    public Integer getNumberInCart() {
        return numberInCart;
    }
}
