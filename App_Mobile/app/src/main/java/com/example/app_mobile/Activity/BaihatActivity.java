package com.example.app_mobile.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;

import com.example.app_mobile.Adapter.DanhsachbaihatAdapter;
import com.example.app_mobile.Model.Album;
import com.example.app_mobile.Model.Baihat;
import com.example.app_mobile.Model.Casi;
import com.example.app_mobile.Model.Tacgia;
import com.example.app_mobile.Model.Theloai;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaihatActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    RecyclerView recyclerViewdanhsachbaihat;
    FloatingActionButton floatingActionButton;
    Baihat baihat;
    Album album;
    Casi casi;
    Theloai theloai;
    Tacgia tacgia;
    ArrayList<Baihat> mangbaihat;
    DanhsachbaihatAdapter danhsachbaihatAdapter;
    ImageView imageViewbaihatback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baihat);
        getSupportActionBar().hide();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        DataIntent();
        init();

        if (baihat != null) {
            setValueInView(baihat.getHinhbaihat());
            GetDataBaihat(baihat.getIdbaihat());
        }

        if (album != null) {
            setValueInView(album.getHinhalbum());
            GetDataAlbum(album.getIdalbum());
        }

        if (casi != null) {
            setValueInView(casi.getHinhcasi());
            GetDataCasi(casi.getTencasi());
        }

        if (theloai != null) {
            setValueInView(theloai.getHinhtheloai());
            GetDataTheloai(theloai.getIdtheloai());
        }

        if (tacgia != null) {
            setValueInView(tacgia.getHinhtacgia());
            GetDataTacgia(tacgia.getTentacgia());
        }
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent.hasExtra("banner")) {
            baihat = (Baihat) intent.getSerializableExtra("banner");
        }
        if (intent.hasExtra("album")) {
            album = (Album) intent.getSerializableExtra("album");
        }
        if (intent.hasExtra("casi")) {
            casi = (Casi) intent.getSerializableExtra("casi");
        }
        if (intent.hasExtra("theloai")) {
            theloai = (Theloai) intent.getSerializableExtra("theloai");
        }

        if (intent.hasExtra("tacgia")) {
            tacgia = (Tacgia) intent.getSerializableExtra("tacgia");
        }
    }

    private void init() {
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar);
        recyclerViewdanhsachbaihat = findViewById(R.id.recycleviewdanhsachbaihat);
        floatingActionButton = findViewById(R.id.floatingactionbutton);
        floatingActionButton.setEnabled(false);
        imageViewbaihatback = findViewById(R.id.imageviewbaihatback);
        imageViewbaihatback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setValueInView(String hinhbaihat) {
        try {
            URL url = new URL(hinhbaihat);
            Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            collapsingToolbarLayout.setBackground(bitmapDrawable);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void GetDataBaihat(String idbaihat) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihat(idbaihat);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(BaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(BaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
                evetClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void GetDataAlbum(String idalbum) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihatAlbum(idalbum);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(BaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(BaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
                evetClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void GetDataTheloai(String idtheloai) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihatTheloai(idtheloai);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(BaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(BaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
                evetClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void GetDataTacgia(String tacgia) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihatTacgia(tacgia);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(BaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(BaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
                evetClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void GetDataCasi(String casi) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetDanhsachbaihatCasi(casi);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                mangbaihat = (ArrayList<Baihat>) response.body();
                danhsachbaihatAdapter = new DanhsachbaihatAdapter(BaihatActivity.this, mangbaihat);
                recyclerViewdanhsachbaihat.setLayoutManager(new LinearLayoutManager(BaihatActivity.this));
                recyclerViewdanhsachbaihat.setAdapter(danhsachbaihatAdapter);
                evetClick();
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void evetClick() {
        floatingActionButton.setEnabled(true);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BaihatActivity.this,PlayNhacActivity.class);
                intent.putExtra("cacbaihat",mangbaihat);
                startActivity(intent);
            }
        });
    }
}