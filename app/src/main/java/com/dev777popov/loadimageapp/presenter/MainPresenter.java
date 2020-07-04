package com.dev777popov.loadimageapp.presenter;

import android.os.Bundle;

import com.dev777popov.loadimageapp.model.MyImages;
import com.dev777popov.loadimageapp.tools.Constants;
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
        startActivityDetail(position);
    }

    public int getClick(int position) {
        return myImages.getImages().get(position).getCountPressImage();
    }

    public String getImgUrl(int position){
        myImages.getImages().get(position).setImgURL("https://mursimka.3dn.ru/screens/1/screens1/little_island/6.jpg");
        return myImages.getImages().get(position).getImgURL();
    }

    private void startActivityDetail(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.IMG_POSITION, position);
        bundle.putString(Constants.IMG_URL, myImages.getImages().get(position).getImgURL());
        getViewState().startActivityDetail(bundle);
    }
}
