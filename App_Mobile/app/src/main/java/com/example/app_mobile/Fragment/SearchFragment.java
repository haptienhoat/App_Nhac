package com.example.app_mobile.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_mobile.Adapter.SearchAlbumAdapter;
import com.example.app_mobile.Adapter.SearchBaiHatAdapter;
import com.example.app_mobile.Adapter.SearchCasiAdapter;
import com.example.app_mobile.Adapter.SearchTacgiaAdapter;
import com.example.app_mobile.Adapter.SearchTheLoaiAdapter;
import com.example.app_mobile.Model.Album;
import com.example.app_mobile.Model.Baihat;
import com.example.app_mobile.Model.Casi;
import com.example.app_mobile.Model.Tacgia;
import com.example.app_mobile.Model.Theloai;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    View view;
    RecyclerView recyclerViewsearchbaihat, recyclerViewsearchalbum, recyclerViewsearchtheloai,
    recyclerViewsearchcasi, recyclerViewsearchtacgia;
    TextView txtkhongcodulieu;
    EditText editTextsearch;
    ImageView imageViewsearch;
    SearchBaiHatAdapter searchBaiHatAdapter;
    SearchAlbumAdapter searchAlbumAdapter;
    SearchTheLoaiAdapter searchTheLoaiAdapter;
    SearchCasiAdapter searchCasiAdapter;
    SearchTacgiaAdapter searchTacgiaAdapter;
    boolean have_data = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerViewsearchbaihat = view.findViewById(R.id.recyclerviewsearchbaihat);
        recyclerViewsearchalbum = view.findViewById(R.id.recyclerviewsearchalbum);
        recyclerViewsearchtheloai = view.findViewById(R.id.recyclerviewsearchtheloai);
        recyclerViewsearchcasi = view.findViewById(R.id.recyclerviewsearchcasi);
        recyclerViewsearchtacgia = view.findViewById(R.id.recyclerviewsearchtacgia);
        txtkhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);
        editTextsearch = view.findViewById(R.id.edittextsearch);
        imageViewsearch = view.findViewById(R.id.imageviewsearch);
        imageViewsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                have_data = false;
                SearchTuKhoaBaiHat(editTextsearch.getText().toString());
                SearchTuKhoaAlbum(editTextsearch.getText().toString());
                SearchTuKhoaTheloai(editTextsearch.getText().toString());
                SearchTuKhoaCasi(editTextsearch.getText().toString());
                SearchTuKhoaTacgia(editTextsearch.getText().toString());
                if (!have_data) {
                    txtkhongcodulieu.setVisibility(View.VISIBLE);
                    recyclerViewsearchbaihat.setVisibility(View.GONE);
                    recyclerViewsearchalbum.setVisibility(View.GONE);
                    recyclerViewsearchtheloai.setVisibility(View.GONE);
                    recyclerViewsearchcasi.setVisibility(View.GONE);
                    recyclerViewsearchtacgia.setVisibility(View.GONE);
                }
            }
        });
        return view;
    }

    private void SearchTuKhoaBaiHat (String query) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetSearchBaihat(query);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> mangbaihat = (ArrayList<Baihat>) response.body();
                if (mangbaihat.size() > 0) {
                    searchBaiHatAdapter = new SearchBaiHatAdapter(getActivity(),mangbaihat);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearchbaihat.setLayoutManager(linearLayoutManager);
                    recyclerViewsearchbaihat.setAdapter(searchBaiHatAdapter);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearchbaihat.setVisibility(View.VISIBLE);
                    have_data = true;
                } else {
                    recyclerViewsearchbaihat.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

    private void SearchTuKhoaAlbum (String query) {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetSearchAlbum(query);
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangalbum = (ArrayList<Album>) response.body();
                if (mangalbum.size() > 0) {
                    searchAlbumAdapter = new SearchAlbumAdapter(getActivity(),mangalbum);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearchalbum.setLayoutManager(linearLayoutManager);
                    recyclerViewsearchalbum.setAdapter(searchAlbumAdapter);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearchalbum.setVisibility(View.VISIBLE);
                    have_data = true;
                } else {
                    recyclerViewsearchbaihat.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void SearchTuKhoaTheloai (String query) {
        Dataservice dataservice = APIService.getService();
        Call<List<Theloai>> callback = dataservice.GetSearchTheloai(query);
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai> mangtheloai = (ArrayList<Theloai>) response.body();
                if (mangtheloai.size() > 0) {
                    searchTheLoaiAdapter = new SearchTheLoaiAdapter(getActivity(),mangtheloai);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearchtheloai.setLayoutManager(linearLayoutManager);
                    recyclerViewsearchtheloai.setAdapter(searchTheLoaiAdapter);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearchtheloai.setVisibility(View.VISIBLE);
                    have_data = true;
                } else {
                    recyclerViewsearchbaihat.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {

            }
        });
    }

    private void SearchTuKhoaCasi (String query) {
        Dataservice dataservice = APIService.getService();
        Call<List<Casi>> callback = dataservice.GetSearchCasi(query);
        callback.enqueue(new Callback<List<Casi>>() {
            @Override
            public void onResponse(Call<List<Casi>> call, Response<List<Casi>> response) {
                ArrayList<Casi> mangcasi = (ArrayList<Casi>) response.body();
                if (mangcasi.size() > 0) {
                    searchCasiAdapter = new SearchCasiAdapter(getActivity(),mangcasi);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearchcasi.setLayoutManager(linearLayoutManager);
                    recyclerViewsearchcasi.setAdapter(searchCasiAdapter);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearchcasi.setVisibility(View.VISIBLE);
                    have_data = true;
                } else {
                    recyclerViewsearchbaihat.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Casi>> call, Throwable t) {

            }
        });
    }

    private void SearchTuKhoaTacgia (String query) {
        Dataservice dataservice = APIService.getService();
        Call<List<Tacgia>> callback = dataservice.GetSearchTacgia(query);
        callback.enqueue(new Callback<List<Tacgia>>() {
            @Override
            public void onResponse(Call<List<Tacgia>> call, Response<List<Tacgia>> response) {
                ArrayList<Tacgia> mangtacgia = (ArrayList<Tacgia>) response.body();
                if (mangtacgia.size() > 0) {
                    searchTacgiaAdapter = new SearchTacgiaAdapter(getActivity(),mangtacgia);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearchtacgia.setLayoutManager(linearLayoutManager);
                    recyclerViewsearchtacgia.setAdapter(searchTacgiaAdapter);
                    txtkhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearchtacgia.setVisibility(View.VISIBLE);
                    have_data = true;
                } else {
                    recyclerViewsearchbaihat.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Tacgia>> call, Throwable t) {

            }
        });
    }
}