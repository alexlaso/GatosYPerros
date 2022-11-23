package com.example.gatosyperros.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gatosyperros.R;


public class AnimalViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewNombre, textViewRazaEspecie;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewNombre = itemView.findViewById(R.id.textViewNombre);
        textViewRazaEspecie = itemView.findViewById(R.id.textViewRazaEspecie);
    }
}
