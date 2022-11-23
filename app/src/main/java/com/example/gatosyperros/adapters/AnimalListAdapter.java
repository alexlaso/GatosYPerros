package com.example.gatosyperros.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.gatosyperros.R;
import com.example.gatosyperros.conexionBaseDatos.Animal;

public class AnimalListAdapter extends ListAdapter<Animal, AnimalViewHolder> {

    public AnimalListAdapter(@NonNull DiffUtil.ItemCallback<Animal> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_vista_unidad, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        Animal actual = getItem(position);
        holder.textViewNombre.setText(actual.getNombre());
        holder.textViewRazaEspecie.setText(actual.getRaza()+" / "+actual.getEspecie());
    }

    public static class AnimalDiff extends DiffUtil.ItemCallback<Animal>{

        @Override
        public boolean areItemsTheSame(@NonNull Animal oldItem, @NonNull Animal newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Animal oldItem, @NonNull Animal newItem) {
            return oldItem.toString().equals(newItem.toString());
        }
    }
}
