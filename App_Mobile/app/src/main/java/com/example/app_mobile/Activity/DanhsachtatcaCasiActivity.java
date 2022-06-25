package com.example.app_mobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.app_mobile.Adapter.AllCasiAdapter;
import com.example.app_mobile.Model.Casi;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaCasiActivity extends AppCompatActivity {

    RecyclerView recyclerViewAllcasi;
    AllCasiAdapter allCasiAdapter;
    ImageView imageViewcasiback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_casi);
        getSupportActionBar().hide();
        init();
        GetData();
    }

    private void init() {
        recyclerViewAllcasi = findViewById(R.id.recycleviewAllcasi);
        imageViewcasiback = findViewById(R.id.imageviewcasiback);
        imageViewcasiback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Casi>> callback = dataservice.GetCasi();
        callback.enqueue(new Callback<List<Casi>>() {
            @Override
            public void onResponse(Call<List<Casi>> call, Response<List<Casi>> response) {
                ArrayList<Casi> mangcasi = (ArrayList<Casi>) response.body();
                allCasiAdapter = new AllCasiAdapter(DanhsachtatcaCasiActivity.this,mangcasi);
                recyclerViewAllcasi.setLayoutManager(new GridLayoutManager(DanhsachtatcaCasiActivity.this,2));
                recyclerViewAllcasi.setAdapter(allCasiAdapter);
            }

            @Override
            public void onFailure(Call<List<Casi>> call, Throwable t) {

            }
        });
    }
}