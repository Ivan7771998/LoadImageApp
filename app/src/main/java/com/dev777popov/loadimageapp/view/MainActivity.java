package com.dev777popov.loadimageapp.view;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.dev777popov.loadimageapp.R;
import com.dev777popov.loadimageapp.adapter.MyAdapterForImage;
import com.dev777popov.loadimageapp.presenter.MainPresenter;
import com.dev777popov.loadimageapp.tools.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.imageRecycler)
    RecyclerView imageRecycler;

    @InjectPresenter
    MainPresenter mainPresenter;

    private MyAdapterForImage adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        imageRecycler.setHasFixedSize(true);
        imageRecycler.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new MyAdapterForImage(this, mainPresenter);
        imageRecycler.setAdapter(adapter);
    }

    @Override
    public void updateView() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void startActivityDetail(Bundle bundle) {
        Intent intent = new Intent(this, DetailImageActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}