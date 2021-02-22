package com.profvalmor.imdb.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Filme.class}, version = 1, exportSchema = false)
public abstract class MyDB extends RoomDatabase {
    public abstract FilmeDAO getFilmeDAO();
}
