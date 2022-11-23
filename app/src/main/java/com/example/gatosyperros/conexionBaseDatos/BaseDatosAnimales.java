package com.example.gatosyperros.conexionBaseDatos;

import android.content.Context;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Animal.class}, version = 1, exportSchema = false)
public abstract class BaseDatosAnimales extends RoomDatabase {
    private static final String DB_NOMBRE = "animales_ddbb";

    public abstract AnimalesDAO animalesDAO();

    // Hilos necesarios para la escritura de la BBDD permitiendo el uso de la aplicación durante esta tarea.
    private static final int NUM_HILOS = 4;
    public static final ExecutorService baseDatosEscritor = Executors.newFixedThreadPool(NUM_HILOS);

    // Patrón Singleton con la intención de que el objeto generado por esta clase sea único en toda la aplicación.
    private static volatile BaseDatosAnimales INSTANCIA;

    public static BaseDatosAnimales getBaseDatosAnimales(final Context contexto){
        if (INSTANCIA == null){
            synchronized (BaseDatosAnimales.class) {
                INSTANCIA = Room.databaseBuilder(contexto.getApplicationContext(), BaseDatosAnimales.class, DB_NOMBRE).addCallback(callbackAnimales).build();
            }
        }
        return INSTANCIA;
    }

    private static RoomDatabase.Callback callbackAnimales = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            baseDatosEscritor.execute(()->{
                AnimalesDAO dao = INSTANCIA.animalesDAO();
                dao.borrarTodo();
                dao.insert(new Animal("Pancracio", "Rottweiler", "Perro"));
            });
        }
    };
}
