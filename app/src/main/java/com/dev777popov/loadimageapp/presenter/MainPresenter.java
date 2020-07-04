package com.dev777popov.loadimageapp.presenter;

import com.dev777popov.loadimageapp.model.MyImages;
import com.dev777popov.loadimageapp.view.MainView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private MyImages myImages;

    public MainPresenter() {
        myImages = new MyImages();
    }

    public void onImageClick(int position) {
        int newCount = myImages.getImages().get(position).getCountPressImage() + 1;
        myImages.getImages().get(position).setCountPressImage(newCount);
        getViewState().updateView();
    }



    public int getClick(int position) {
        return myImages.getImages().get(position).getCountPressImage();
    }
}
