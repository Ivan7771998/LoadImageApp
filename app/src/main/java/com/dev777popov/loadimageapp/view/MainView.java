package com.dev777popov.loadimageapp.view;

import android.os.Bundle;

import moxy.MvpView;

public interface MainView extends MvpView {

    void updateView();

    void startActivityDetail(Bundle bundle);
}
