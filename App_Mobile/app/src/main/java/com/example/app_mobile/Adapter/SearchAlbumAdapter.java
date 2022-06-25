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

public class SearchAlbumAdapter extends RecyclerView.Adapter<SearchAlbumAdapter.ViewHolder> {

    Context context;
    ArrayList<Album> mangalbum;

    public SearchAlbumAdapter(Context context, ArrayList<Album> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_search_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = mangalbum.get(position);
        holder.txtTenalbum.setText("Album : " + album.getTenalbum());
        holder.txtCasi.setText(album.getCasi());
        Picasso.with(context).load(album.getHinhalbum()).into(holder.imgalbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenalbum, txtCasi;
        ImageView imgalbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenalbum = itemView.findViewById(R.id.textviewsearchtenalbum);
            txtCasi = itemView.findViewById(R.id.textviewsearchcasi);
            imgalbum = itemView.findViewById(R.id.imageviewSearchalbum);
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
