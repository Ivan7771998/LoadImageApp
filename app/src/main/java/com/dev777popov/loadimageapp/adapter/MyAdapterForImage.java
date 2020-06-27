package com.dev777popov.loadimageapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dev777popov.loadimageapp.R;
import com.dev777popov.loadimageapp.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapterForImage extends RecyclerView.Adapter<MyAdapterForImage.MyViewHolder> {

    private MainPresenter mainPresenter;
    private Context context;

    public MyAdapterForImage(Context context, MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
        this.context = context;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;

        @BindView(R.id.textClick)
        TextView textClick;

        @BindView(R.id.cardView)
        CardView cardView;

        public MyViewHolder(View it) {
            super(it);
            ButterKnife.bind(this, it);
        }
    }

    @NonNull
    @Override
    public MyAdapterForImage.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_image_recycler, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterForImage.MyViewHolder holder, int position) {

        Glide.with(context)
                .load("https://mursimka.3dn.ru/screens/1/screens1/little_island/6.jpg")
                .into(holder.imageView);
        holder.textClick.setText(new StringBuilder("Вы нажали: +" + mainPresenter.getClick(position)));
        holder.cardView.setOnClickListener(v -> mainPresenter.onImageClick(position));
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
