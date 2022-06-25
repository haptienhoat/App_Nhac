package com.example.app_mobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.app_mobile.Adapter.AllTacgiaAdapter;
import com.example.app_mobile.Model.Tacgia;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaTacgiaActivity extends AppCompatActivity {

    RecyclerView recyclerViewAlltacgia;
    AllTacgiaAdapter allTacgiaAdapter;
    ImageView imageViewtacgiaback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatca_tacgia);
        getSupportActionBar().hide();
        init();
        GetData();
    }

    private void init() {
        recyclerViewAlltacgia = findViewById(R.id.recycleviewAlltacgia);
        imageViewtacgiaback = findViewById(R.id.imageviewtacgiaback);
        imageViewtacgiaback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Tacgia>> callback = dataservice.GetTacgia();
        callback.enqueue(new Callback<List<Tacgia>>() {
            @Override
            public void onResponse(Call<List<Tacgia>> call, Response<List<Tacgia>> response) {
                ArrayList<Tacgia> mangtacgia = (ArrayList<Tacgia>) response.body();
                allTacgiaAdapter = new AllTacgiaAdapter(DanhsachtatcaTacgiaActivity.this,mangtacgia);
                recyclerViewAlltacgia.setLayoutManager(new GridLayoutManager(DanhsachtatcaTacgiaActivity.this,2));
                recyclerViewAlltacgia.setAdapter(allTacgiaAdapter);
            }

            @Override
            public void onFailure(Call<List<Tacgia>> call, Throwable t) {

            }
        });
    }
}