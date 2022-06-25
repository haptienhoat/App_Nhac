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

public class AllTheloaiAdapter extends RecyclerView.Adapter<AllTheloaiAdapter.ViewHolder> {
    Context context;
    ArrayList<Theloai> theloaiArrayList;

    public AllTheloaiAdapter(Context context, ArrayList<Theloai> theloaiArrayList) {
        this.context = context;
        this.theloaiArrayList = theloaiArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_theloai,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Theloai theloai = theloaiArrayList.get(position);
        Picasso.with(context).load((theloai.getHinhtheloai())).into(holder.imgalltheloai);
        holder.txttenalltheloai.setText(theloai.getTentheloai());
    }

    @Override
    public int getItemCount() {
        return theloaiArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgalltheloai;
        TextView txttenalltheloai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgalltheloai = itemView.findViewById(R.id.imageviewalltheloai);
            txttenalltheloai = itemView.findViewById(R.id.textviewalltheloai);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BaihatActivity.class);
                    intent.putExtra("theloai",theloaiArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
