package com.dev777popov.loadimageapp.model;

public class MyImage {

    private int countPressImage = 0;

    private String imgURL = "";

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public int getCountPressImage() {
        return countPressImage;
    }

    public void setCountPressImage(int countPressImage) {
        this.countPressImage = countPressImage;
    }
}
