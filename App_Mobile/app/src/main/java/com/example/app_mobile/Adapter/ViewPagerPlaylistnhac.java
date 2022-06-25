package com.example.app_mobile.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPagerPlaylistnhac extends FragmentStateAdapter {
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    public ViewPagerPlaylistnhac(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment) {
        fragmentArrayList.add(fragment);
    }

    public Fragment getFragment(int position) {
        return fragmentArrayList.get(position);
    }

}
