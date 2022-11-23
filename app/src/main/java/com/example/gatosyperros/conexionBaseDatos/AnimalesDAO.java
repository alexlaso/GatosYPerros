package com.example.gatosyperros.conexionBaseDatos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import androidx.room.Insert;

import java.util.List;

@Dao
public interface AnimalesDAO {
    @Insert
    void insert(Animal animal);

    @Query("SELECT * from animales_tabla ORDER BY nombre desc")
    LiveData<List<Animal>> seleccionarTablaAnimales();

    @Query("DELETE FROM animales_tabla")
    void borrarTodo();

    @Delete
    void borrarAnimal(Animal animal);

    /*@Query("SELECT * FROM animales_tabla WHERE edad > :minAge")
    LiveData<List<Animal>> animalesMayoresQue(int minAge);
*/
}