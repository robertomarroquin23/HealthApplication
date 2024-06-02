package com.itca.healthapplication.ConfigRecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itca.healthapplication.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView ;
    TextView tituloView, consejoView;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imagen1);
        tituloView = itemView.findViewById(R.id.Titulo);
        consejoView = itemView.findViewById(R.id.Consejo);
    }
}
