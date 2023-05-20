package com.example.foodorderapp.Models;

public class CategoryModel {
    int image;
    String title;

    public CategoryModel(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }
}
