package com.example.pokeapi.model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pokemon.class}, version = 2)
public abstract class DataBase extends RoomDatabase {
    public abstract PokemonDAO getPokemonDao();
}
