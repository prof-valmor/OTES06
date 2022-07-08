package com.example.pokeapi.model;


import android.graphics.Bitmap;

public class PokemonPOJO {
    public int height;
    public int weight;
    public String name;
    public Bitmap image;

    @Override
    public String toString() {
        return "PokemonPOJO{" +
                "height=" + height +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
