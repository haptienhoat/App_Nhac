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

import com.example.app_mobile.Activity.DanhsachtatcaTacgiaActivity;
import com.example.app_mobile.Adapter.TacgiaAdapter;
import com.example.app_mobile.Model.Tacgia;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TacgiaFragment extends Fragment {

    View view;
    RecyclerView recyclerViewtacgia;
    TextView txtxemthemtacgia;
    TacgiaAdapter tacgiaAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tacgia, container, false);
        init();
        txtxemthemtacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcaTacgiaActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void init() {
        recyclerViewtacgia = view.findViewById(R.id.recycleviewtacgia);
        txtxemthemtacgia = view.findViewById((R.id.textxemthemtacgia));
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Tacgia>> callback = dataservice.GetTacgia();
        callback.enqueue(new Callback<List<Tacgia>>() {
            @Override
            public void onResponse(Call<List<Tacgia>> call, Response<List<Tacgia>> response) {
                ArrayList<Tacgia> res = (ArrayList<Tacgia>) response.body();
                ArrayList<Tacgia> tacgias = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    tacgias.add(res.get(i));
                }
                tacgiaAdapter = new TacgiaAdapter(getActivity(),tacgias);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewtacgia.setLayoutManager(linearLayoutManager);
                recyclerViewtacgia.setAdapter(tacgiaAdapter);
            }

            @Override
            public void onFailure(Call<List<Tacgia>> call, Throwable t) {

            }
        });
    }
}