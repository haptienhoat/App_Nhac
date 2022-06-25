package com.example.app_mobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_mobile.Activity.BaihatActivity;
import com.example.app_mobile.Model.Casi;
import com.example.app_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchCasiAdapter extends RecyclerView.Adapter<SearchCasiAdapter.ViewHolder> {

    Context context;
    ArrayList<Casi> mangcasi;

    public SearchCasiAdapter(Context context, ArrayList<Casi> mangcasi) {
        this.context = context;
        this.mangcasi = mangcasi;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_search_ca_si,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Casi casi = mangcasi.get(position);
        holder.txtTencasi.setText("Ca sĩ : " + casi.getTencasi());
        Picasso.with(context).load(casi.getHinhcasi()).into(holder.imgcasi);
    }

    @Override
    public int getItemCount() {
        return mangcasi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTencasi;
        ImageView imgcasi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTencasi = itemView.findViewById(R.id.textviewsearchtencasi);
            imgcasi = itemView.findViewById(R.id.imageviewSearchcasi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BaihatActivity.class);
                    intent.putExtra("casi",mangcasi.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
