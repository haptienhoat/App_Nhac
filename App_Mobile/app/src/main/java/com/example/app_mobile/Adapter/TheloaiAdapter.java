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
import com.example.app_mobile.Model.Theloai;
import com.example.app_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TheloaiAdapter extends RecyclerView.Adapter<TheloaiAdapter.ViewHolder> {
    Context context;
    ArrayList<Theloai> mangtheloai;

    public TheloaiAdapter(Context context, ArrayList<Theloai> mangtheloai) {
        this.context = context;
        this.mangtheloai = mangtheloai;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_theloai, parent, false);
        return new TheloaiAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Theloai theloai = mangtheloai.get(position);
        holder.txttheloai.setText(theloai.getTentheloai());
        Picasso.with(context).load(theloai.getHinhtheloai()).into(holder.imgtheloai);
    }

    @Override
    public int getItemCount() {
        return mangtheloai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgtheloai;
        TextView txttheloai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgtheloai = itemView.findViewById(R.id.imageviewtheloai);
            txttheloai = itemView.findViewById(R.id.textviewtheloai);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BaihatActivity.class);
                    intent.putExtra("theloai",mangtheloai.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
