package com.example.nutrimate;

public class FoodModel {
    String nameF;
    int imageF;

    public FoodModel (String nameF, int imageF){
        this.nameF = nameF;
        this.imageF = imageF;
    }

    public String getName() {
        return nameF;
    }
    public int getImage() {
        return imageF;
    }
}
