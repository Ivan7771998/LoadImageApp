package com.dev777popov.loadimageapp.model;

import java.util.ArrayList;
import java.util.List;

public class MyImages {

    private List<MyImage> images;

    public MyImages() {
        createMyImages();
    }

    public List<MyImage> getImages() {
        return images;
    }

    private void createMyImages() {
        images = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            images.add(new MyImage());
        }
    }
}
