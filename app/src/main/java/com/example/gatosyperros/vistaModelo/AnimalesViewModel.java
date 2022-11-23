package com.example.gatosyperros.vistaModelo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gatosyperros.conexionBaseDatos.Animal;
import com.example.gatosyperros.repositorios.RepositorioAnimalesDB;

import java.util.List;

public class AnimalesViewModel extends AndroidViewModel {

    private RepositorioAnimalesDB repositorioAnimalesDB;

    private LiveData<List<Animal>> todosLosAnimales;

    public AnimalesViewModel(@NonNull Application application) {
        super(application);
        repositorioAnimalesDB = new RepositorioAnimalesDB(application);
        todosLosAnimales = repositorioAnimalesDB.getTodosLosAnimales();
    }

    public LiveData<List<Animal>> getTodosLosAnimales(){
        return todosLosAnimales;
    }

    public void insertarNuevoAnimal(Animal nuevoAnimal){
        repositorioAnimalesDB.insertarAnimal(nuevoAnimal);
    }
}
