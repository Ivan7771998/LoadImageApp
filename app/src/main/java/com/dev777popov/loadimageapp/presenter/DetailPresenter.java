package com.dev777popov.loadimageapp.presenter;

import android.content.Intent;
import android.util.Log;

import com.dev777popov.loadimageapp.model.MyImage;
import com.dev777popov.loadimageapp.tools.Constants;
import com.dev777popov.loadimageapp.view.DetailView;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailView> {

    private static final String TAG = "DetailPresenter";
    private MyImage myImage;

    public DetailPresenter() {
        myImage = new MyImage();
    }

    public void setDataFromExtra(Intent data) {
        if (data.getExtras() != null) {
            myImage.setImgURL(data.getExtras().getString(Constants.IMG_URL));
            myImage.setCountPressImage(data.getExtras().getInt(Constants.IMG_POSITION));
            getViewState().loadImage(myImage.getImgURL());
            showLogCurrentImg(myImage.getCountPressImage());
        }
    }

    private void showLogCurrentImg(int position) {
        Log.d(TAG, "Pressed image with position: " + position);
    }
}
