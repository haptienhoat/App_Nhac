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

import com.example.app_mobile.Activity.DanhsachtatcaCasiActivity;
import com.example.app_mobile.Adapter.CasiAdapter;
import com.example.app_mobile.Model.Casi;
import com.example.app_mobile.R;
import com.example.app_mobile.Service.APIService;
import com.example.app_mobile.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CasiFragment extends Fragment {

    View view;
    RecyclerView recyclerViewcasi;
    TextView txtxemthemcasi;
    CasiAdapter casiAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_casi, container, false);
        init();
        txtxemthemcasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DanhsachtatcaCasiActivity.class);
                startActivity(intent);
            }
        });
        GetData();
        return view;
    }

    private void init() {
        recyclerViewcasi = view.findViewById(R.id.recycleviewcasi);
        txtxemthemcasi = view.findViewById((R.id.textxemthemcasi));
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Casi>> callback = dataservice.GetCasi();
        callback.enqueue(new Callback<List<Casi>>() {
            @Override
            public void onResponse(Call<List<Casi>> call, Response<List<Casi>> response) {
                ArrayList<Casi> res = (ArrayList<Casi>) response.body();
                ArrayList<Casi> casis = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    casis.add(res.get(i));
                }
                casiAdapter = new CasiAdapter(getActivity(),casis);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewcasi.setLayoutManager(linearLayoutManager);
                recyclerViewcasi.setAdapter(casiAdapter);
            }

            @Override
            public void onFailure(Call<List<Casi>> call, Throwable t) {

            }
        });
    }
}