package com.example.app_mobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.app_mobile.Adapter.AllAlbumAdapter;
import com.example.app_mobile.Model.Album;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaAlbumActivity extends AppCompatActivity {

    RecyclerView recyclerViewAllalbum;
    AllAlbumAdapter allAlbumAdapter;
    ImageView imageViewalbumback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_album);
        getSupportActionBar().hide();
        init();
        GetData();
    }

    private void init() {
        recyclerViewAllalbum = findViewById(R.id.recycleviewAllalbum);
        imageViewalbumback = findViewById(R.id.imageviewalbumback);
        imageViewalbumback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangalbum = (ArrayList<Album>) response.body();
                allAlbumAdapter = new AllAlbumAdapter(DanhsachtatcaAlbumActivity.this,mangalbum);
                recyclerViewAllalbum.setLayoutManager(new GridLayoutManager(DanhsachtatcaAlbumActivity.this,2));
                recyclerViewAllalbum.setAdapter(allAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }
}