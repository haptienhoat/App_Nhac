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

public class AllCasiAdapter extends RecyclerView.Adapter<AllCasiAdapter.ViewHolder> {
    Context context;
    ArrayList<Casi> casiArrayList;

    public AllCasiAdapter(Context context, ArrayList<Casi> casiArrayList) {
        this.context = context;
        this.casiArrayList = casiArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_casi,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Casi casi = casiArrayList.get(position);
        Picasso.with(context).load((casi.getHinhcasi())).into(holder.imgallcasi);
        holder.txttenallcasi.setText(casi.getTencasi());
    }

    @Override
    public int getItemCount() {
        return casiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgallcasi;
        TextView txttenallcasi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgallcasi = itemView.findViewById(R.id.imageviewallcasi);
            txttenallcasi = itemView.findViewById(R.id.textviewallcasi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BaihatActivity.class);
                    intent.putExtra("casi",casiArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
