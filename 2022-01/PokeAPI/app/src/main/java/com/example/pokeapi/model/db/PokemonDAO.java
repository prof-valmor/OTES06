package com.example.pokeapi.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PokemonDAO {
    @Insert
    void add(Pokemon pokemon);
    @Delete
    void remove(Pokemon pokemon);
    @Query("delete from Pokemon where Pokemon.name = :name")
    void removeByName(String name);
    @Query("select * from Pokemon where Pokemon.name = :name")
    Pokemon get(String name);
}
