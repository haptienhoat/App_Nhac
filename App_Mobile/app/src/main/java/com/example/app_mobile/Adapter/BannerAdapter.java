package com.example.app_mobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.app_mobile.Activity.BaihatActivity;
import com.example.app_mobile.Model.Baihat;
import com.example.app_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Baihat> arrayListBanner;

    public BannerAdapter(Context context, ArrayList<Baihat> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }

    @Override
    public int getCount() {
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);
        ImageView imgbackgroundbanner = view.findViewById(R.id.imageviewbackgroundbanner);

        Picasso.with(context).load(arrayListBanner.get(position).getHinhbaihat()).into(imgbackgroundbanner);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BaihatActivity.class);
                intent.putExtra("banner",arrayListBanner.get(position));
                context.startActivity(intent);
            }
        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
