package com.example.app_mobile.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app_mobile.Activity.DanhsachtatcaAlbumActivity;
import com.example.app_mobile.Adapter.AlbumAdapter;
import com.example.app_mobile.Model.Album;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumFragment extends Fragment {
    View view;
    RecyclerView recyclerViewalbum;
    TextView txtxemthemalbum;
    AlbumAdapter albumAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_album, container, false);
        init();
        txtxemthemalbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcaAlbumActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void init() {
        recyclerViewalbum = (RecyclerView) view.findViewById(R.id.recycleviewalbum);
        txtxemthemalbum = view.findViewById((R.id.textxemthemalbum));
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> res = (ArrayList<Album>) response.body();
                ArrayList<Album> albums = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    albums.add(res.get(i));
                }
                albumAdapter = new AlbumAdapter(getActivity(),albums);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewalbum.setLayoutManager(linearLayoutManager);
                recyclerViewalbum.setAdapter(albumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });

    }
}