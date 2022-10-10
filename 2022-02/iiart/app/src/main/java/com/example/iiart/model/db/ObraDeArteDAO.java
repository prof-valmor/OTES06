package com.example.iiart.model.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ObraDeArteDAO {
    @Query("SELECT * FROM ObraDeArte")
    List<ObraDeArte> getAll();
    @Insert
    void add(ObraDeArte obra);
}
