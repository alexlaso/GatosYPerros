package com.example.gatosyperros.repositorios;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.gatosyperros.conexionBaseDatos.Animal;
import com.example.gatosyperros.conexionBaseDatos.AnimalesDAO;
import com.example.gatosyperros.conexionBaseDatos.BaseDatosAnimales;

import java.util.List;

public class RepositorioAnimalesDB {
    private AnimalesDAO animalesDAO;
    private LiveData<List<Animal>> todosLosAnimales;

    public RepositorioAnimalesDB(Application app){
        BaseDatosAnimales baseDatosAnimales = BaseDatosAnimales.getBaseDatosAnimales(app);
        animalesDAO = baseDatosAnimales.animalesDAO();
        todosLosAnimales = animalesDAO.seleccionarTablaAnimales();
        generarInicial();
    }
    public LiveData<List<Animal>> getTodosLosAnimales(){
        return  todosLosAnimales;
    }

    public void insertarAnimal(Animal nuevoAnimal){
        BaseDatosAnimales.baseDatosEscritor.execute(()-> animalesDAO.insert(nuevoAnimal));
    }

    public void generarInicial(){
        Animal animal = new Animal("Pancracio", "Rottweiler", "Perro");
    }
    // Metodo alternativo mas anticuado
    /*
    public void insertarAnimal(Animal nuevoAnimal){
        BaseDatosAnimales.baseDatosEscritor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        animalesDAO.insert(nuevoAnimal);
                    }
                }
        );
    }
    */

    // Resto de metodos de relacion con la DDBB
}
