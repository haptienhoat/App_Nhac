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

import com.example.app_mobile.Activity.DanhsachtatcaTheloaiActivity;
import com.example.app_mobile.Adapter.TheloaiAdapter;
import com.example.app_mobile.Model.Theloai;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheloaiFragment extends Fragment {

    View view;
    RecyclerView recyclerViewtheloai;
    TextView txtxemthemtheloai;
    TheloaiAdapter theloaiAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_theloai, container, false);
        init();
        txtxemthemtheloai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcaTheloaiActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void init() {
        recyclerViewtheloai = view.findViewById(R.id.recycleviewtheloai);
        txtxemthemtheloai = view.findViewById((R.id.textxemthemtheloai));
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Theloai>> callback = dataservice.GetCategory();
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai> res = (ArrayList<Theloai>) response.body();
                ArrayList<Theloai> theloais = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    theloais.add(res.get(i));
                }
                theloaiAdapter = new TheloaiAdapter(getActivity(),theloais);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewtheloai.setLayoutManager(linearLayoutManager);
                recyclerViewtheloai.setAdapter(theloaiAdapter);
            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {

            }
        });
    }
}