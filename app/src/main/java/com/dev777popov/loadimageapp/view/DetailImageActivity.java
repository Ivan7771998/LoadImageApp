package com.dev777popov.loadimageapp.view;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dev777popov.loadimageapp.R;
import com.dev777popov.loadimageapp.presenter.DetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class DetailImageActivity extends MvpAppCompatActivity implements DetailView{

    @BindView(R.id.imgDetail)
    ImageView imgDetail;

    @InjectPresenter
    DetailPresenter detailPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_image);
        ButterKnife.bind(this);
        if(getIntent()!=null)
        detailPresenter.setDataFromExtra(getIntent());
    }

    @Override
    public void loadImage(String url) {
        Glide.with(this)
                .load(url)
                .into(imgDetail);
    }
}