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
import com.example.app_mobile.Model.Album;
import com.example.app_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> mangalbum;

    public AlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = mangalbum.get(position);
        holder.txtcasialbum.setText(album.getCasi());
        holder.txttenalbum.setText(album.getTenalbum());
        Picasso.with(context).load(album.getHinhalbum()).into(holder.imgalbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgalbum;
        TextView txttenalbum, txtcasialbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgalbum = itemView.findViewById(R.id.imageviewalbum);
            txttenalbum = itemView.findViewById(R.id.textviewalbum);
            txtcasialbum = itemView.findViewById(R.id.textviewtencasialbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BaihatActivity.class);
                    intent.putExtra("album",mangalbum.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
