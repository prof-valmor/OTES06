package com.example.pokeapi.model.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Locale;

@Entity
public class Pokemon {
    @PrimaryKey
    @NonNull
    private String name;
    private double weight;
    private double height;
    private int id;

    public Pokemon(@NonNull String name, double weight, double height, int id) {
        this.name = name.toLowerCase(Locale.ROOT);
        this.weight = weight;
        this.height = height;
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
