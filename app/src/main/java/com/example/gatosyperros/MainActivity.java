package com.example.gatosyperros;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gatosyperros.adapters.AnimalListAdapter;
import com.example.gatosyperros.conexionBaseDatos.Animal;
import com.example.gatosyperros.vistaModelo.AnimalesViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaAnimales;
    AnimalesViewModel animalesViewModel;
    FloatingActionButton botonNuevoAnimal;
    public static final int REQUEST_CODE_NUEVO_ANIMAL=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonNuevoAnimal = findViewById(R.id.botonNuevoAnimal);
        botonNuevoAnimal.setOnClickListener(view ->{
            lanzarNuevoAnimal();
        });

        listaAnimales = findViewById(R.id.listaAnimales);
        final AnimalListAdapter adapter = new AnimalListAdapter(new AnimalListAdapter.AnimalDiff());
        listaAnimales.setLayoutManager(new LinearLayoutManager(this));
        listaAnimales.setAdapter(adapter);

        animalesViewModel = new ViewModelProvider(this).get(AnimalesViewModel.class);
        animalesViewModel.getTodosLosAnimales().observe(this, animals ->{
            adapter.submitList(animals);
        });
    }
    private void lanzarNuevoAnimal(){
        Intent intent = new Intent(MainActivity.this,NuevoAnimal.class);
        startActivityForResult(intent,REQUEST_CODE_NUEVO_ANIMAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_NUEVO_ANIMAL && resultCode == RESULT_OK){
            Animal nuevoAnimal = new Animal(data.getStringExtra("nombre"),data.getStringExtra("raza"), data.getStringExtra("especie"));
           /* Animal nuevoAnimalSerializable = (Animal) data.getSerializableExtra("nuevoAnimal");
            Bundle bundle = data.getBundleExtra("nuevoAnimal");
            Animal nuevoAnimalBundle = (Animal) bundle.get("animal");*/
            animalesViewModel.insertarNuevoAnimal(nuevoAnimal);
        }else{
            Toast.makeText(getApplicationContext(), "Error, faltan datos", Toast.LENGTH_LONG).show();
        }
    }
}