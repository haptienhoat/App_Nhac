package com.example.app_mobile.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app_mobile.Activity.PlayNhacActivity;
import com.example.app_mobile.Adapter.PlaynhacAdapter;
import com.example.app_mobile.R;

public class PlayDanhSachCacBaiHatFragment extends Fragment {

    View view;
    RecyclerView recyclerViewplaynhac;
    PlaynhacAdapter playnhacAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_play_danh_sach_cac_bai_hat, container, false);
        recyclerViewplaynhac = view.findViewById(R.id.recyclerviewPlaybaihat);
        playnhacAdapter = new PlaynhacAdapter(getActivity(), PlayNhacActivity.mangbaihat);
        recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewplaynhac.setAdapter(playnhacAdapter);
        return view;
    }
}