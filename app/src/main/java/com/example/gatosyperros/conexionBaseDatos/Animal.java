package com.example.gatosyperros.conexionBaseDatos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Entity(tableName="animales_tabla")
public class Animal implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name="id")
    private int identificadorPK;
    @ColumnInfo(name="nombre")
    private String nombre;
    @ColumnInfo(name="raza")
    private String raza;
    @ColumnInfo(name="especie")
    private String especie;
    /*@ColumnInfo(name="edad")
    private int edad;*/

    public Animal(String nombre, String raza, String especie/*, int edad*/) {
        this.nombre = nombre;
        this.raza = raza;
        this.especie = especie;
        /*this.edad = edad;*/
    }

    public int getIdentificadorPK() {
        return identificadorPK;
    }

    public void setIdentificadorPK(int identificadorPK) {
        this.identificadorPK = identificadorPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
/*
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }*/

    @Override
    public String toString() {
        return "Animal{" +
                "identificadorPK=" + identificadorPK +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", especie='" + especie + '\'' +
/*
                ", edad=" + edad +
*/
                '}';
    }
}
