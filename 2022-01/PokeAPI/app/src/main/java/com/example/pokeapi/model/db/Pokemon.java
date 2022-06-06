package com.example.pokeapi.model.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pokemon {
    @PrimaryKey
    @NonNull
    private String name;
    private double weight;
    private double height;
    private String imagePath;

    public Pokemon(@NonNull String name, double weight, double height, String imagePath) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.imagePath = imagePath;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getName() {
        return name;
    }
}
