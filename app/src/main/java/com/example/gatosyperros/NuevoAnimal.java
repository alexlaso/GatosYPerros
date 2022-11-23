package com.example.gatosyperros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

public class NuevoAnimal extends AppCompatActivity {
    EditText textViewNombreNuevo, textViewRazaNuevo, textViewEspecieNuevo;
    Button botonGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_animal);

        textViewNombreNuevo = findViewById(R.id.textViewNombreNuevo);
        textViewRazaNuevo = findViewById(R.id.textViewRazaNuevo);
        textViewEspecieNuevo = findViewById(R.id.textViewEspecieNuevo);
        botonGuardar = findViewById(R.id.buttonGuardar);

        botonGuardar.setOnClickListener(view -> guardarAnimal());
    }

    private void guardarAnimal(){
        Intent intentRespuesta = new Intent();
        if(algunoEstaVacio()){
            setResult(RESULT_CANCELED);
    }
    else{
        prepararAnimal(intentRespuesta);
    }
    finish();
    }

    private void prepararAnimal(Intent intentRespuesta){
        intentRespuesta.putExtra("nombre",textViewNombreNuevo.getText().toString());
        intentRespuesta.putExtra("raza",textViewRazaNuevo.getText().toString());
        intentRespuesta.putExtra("especie",textViewEspecieNuevo.getText().toString());

        setResult(RESULT_OK,intentRespuesta);
    }

    private boolean algunoEstaVacio(){
        return TextUtils.isEmpty(textViewNombreNuevo.getText())||TextUtils.isEmpty(textViewEspecieNuevo.getText())||TextUtils.isEmpty(textViewRazaNuevo.getText());
    }
}