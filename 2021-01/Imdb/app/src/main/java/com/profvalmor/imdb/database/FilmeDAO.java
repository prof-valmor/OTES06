package com.profvalmor.imdb.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FilmeDAO {
    @Insert
    void insert(Filme filme);

    @Delete
    void remove(Filme filme);

    @Query("delete from Filme")
    void removeAll();

    @Query("select * from Filme")
    List<Filme> getAll();
}
