package com.example.app_mobile.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.example.app_mobile.Activity.PlayNhacActivity;
import com.example.app_mobile.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DiaNhacFragment extends Fragment {

    View view;
    CircleImageView circleImageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dia_nhac, container, false);
        circleImageView = view.findViewById(R.id.imageviewcircle);
        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotate.setDuration(10000);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setRepeatMode(Animation.RESTART);
        circleImageView.startAnimation(rotate);
        if (PlayNhacActivity.mangbaihat.size() > 0) {
            Picasso.with(getContext()).load(PlayNhacActivity.mangbaihat.get(0).getHinhbaihat()).into(circleImageView);
        }
        return view;
    }

    public void Playnhac(String hinhanh) {
        Picasso.with(getContext()).load(hinhanh).into(circleImageView);
    }
}