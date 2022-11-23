package com.example.gatosyperros.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gatosyperros.R;
import com.example.gatosyperros.conexionBaseDatos.Animal;

import java.util.List;

public class AnimalAdapterRecyclerView extends RecyclerView.Adapter<AnimalViewHolder> {

    private List<Animal> listaAnimales;
    public AnimalAdapterRecyclerView (List<Animal> lista){
        this.listaAnimales = lista;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_vista_unidad, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.textViewNombre.setText(listaAnimales.get(position).getNombre());
        holder.textViewRazaEspecie.setText(listaAnimales.get(position).getRaza()+" / "+ listaAnimales.get(position).getEspecie());
    }

    @Override
    public int getItemCount() {
        return listaAnimales.size();
    }
}
