package com.example.app_mobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_mobile.Activity.PlayNhacActivity;
import com.example.app_mobile.Model.Baihat;
import com.example.app_mobile.R;

import java.util.ArrayList;

public class DanhsachbaihatAdapter extends RecyclerView.Adapter<DanhsachbaihatAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> mangbaihat;

    public DanhsachbaihatAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_bai_hat, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txttenbaihat.setText(baihat.getTenbaihat());
        holder.txtcasi.setText(baihat.getCasi());
        holder.txtindex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public  class  ViewHolder extends RecyclerView.ViewHolder {
        TextView txtindex, txttenbaihat, txtcasi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txtcasi = itemView.findViewById(R.id.textviewtencasi);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihat);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc",mangbaihat.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
