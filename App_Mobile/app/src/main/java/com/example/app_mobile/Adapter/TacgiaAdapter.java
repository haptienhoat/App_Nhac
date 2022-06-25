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
import com.example.app_mobile.Model.Tacgia;
import com.example.app_mobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TacgiaAdapter extends RecyclerView.Adapter<TacgiaAdapter.ViewHolder> {
    Context context;
    ArrayList<Tacgia> mangtacgia;

    public TacgiaAdapter(Context context, ArrayList<Tacgia> mangtacgia) {
        this.context = context;
        this.mangtacgia = mangtacgia;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_tacgia, parent, false);
        return new TacgiaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tacgia tacgia = mangtacgia.get(position);
        holder.txttacgia.setText(tacgia.getTentacgia());
        Picasso.with(context).load(tacgia.getHinhtacgia()).into(holder.imgtacgia);
    }

    @Override
    public int getItemCount() {
        return mangtacgia.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgtacgia;
        TextView txttacgia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgtacgia = itemView.findViewById(R.id.imageviewtacgia);
            txttacgia = itemView.findViewById(R.id.textviewtacgia);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BaihatActivity.class);
                    intent.putExtra("tacgia",mangtacgia.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
