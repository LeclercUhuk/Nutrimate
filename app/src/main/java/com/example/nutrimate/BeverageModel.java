package com.example.nutrimate;

public class BeverageModel {
    String nameB;
    int imageB;

    public BeverageModel (String nameB, int imageB){
        this.nameB = nameB;
        this.imageB = imageB;
    }

    public String getName() {
        return nameB;
    }
    public int getImage() {
        return imageB;
    }
}
