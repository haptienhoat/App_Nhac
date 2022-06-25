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

public class AllTacgiaAdapter extends RecyclerView.Adapter<AllTacgiaAdapter.ViewHolder> {
    Context context;
    ArrayList<Tacgia> tacgiaArrayList;

    public AllTacgiaAdapter(Context context, ArrayList<Tacgia> tacgiaArrayList) {
        this.context = context;
        this.tacgiaArrayList = tacgiaArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_tacgia,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tacgia tacgia = tacgiaArrayList.get(position);
        Picasso.with(context).load((tacgia.getHinhtacgia())).into(holder.imgalltacgia);
        holder.txttenalltacgia.setText(tacgia.getTentacgia());
    }

    @Override
    public int getItemCount() {
        return tacgiaArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgalltacgia;
        TextView txttenalltacgia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgalltacgia = itemView.findViewById(R.id.imageviewalltacgia);
            txttenalltacgia = itemView.findViewById(R.id.textviewalltacgia);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, BaihatActivity.class);
                    intent.putExtra("tacgia",tacgiaArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
