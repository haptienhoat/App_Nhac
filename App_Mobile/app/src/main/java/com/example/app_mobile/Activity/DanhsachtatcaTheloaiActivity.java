package com.example.app_mobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.app_mobile.Adapter.AllTheloaiAdapter;
import com.example.app_mobile.Model.Theloai;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaTheloaiActivity extends AppCompatActivity {

    RecyclerView recyclerViewAlltheloai;
    AllTheloaiAdapter allTheloaiAdapter;
    ImageView imageViewtheloaiback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_theloai);
        getSupportActionBar().hide();
        init();
        GetData();
    }

    private void init() {
        recyclerViewAlltheloai = findViewById(R.id.recycleviewAlltheloai);
        imageViewtheloaiback = findViewById(R.id.imageviewtheloaiback);
        imageViewtheloaiback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Theloai>> callback = dataservice.GetCategory();
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai> mangtheloai = (ArrayList<Theloai>) response.body();
                allTheloaiAdapter = new AllTheloaiAdapter(DanhsachtatcaTheloaiActivity.this,mangtheloai);
                recyclerViewAlltheloai.setLayoutManager(new GridLayoutManager(DanhsachtatcaTheloaiActivity.this,2));
                recyclerViewAlltheloai.setAdapter(allTheloaiAdapter);
            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {

            }
        });
    }
}