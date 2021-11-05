package br.udesc.datastorage.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PessoaDAO {
    @Query("select * from Pessoa")
    List<Pessoa> getAll();

    @Insert
    void add(Pessoa p);

    @Delete
    void delete(Pessoa p);
}
