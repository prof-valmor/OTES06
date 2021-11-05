package br.udesc.datastorage.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pessoa.class}, version = 1)
public abstract class TheDatabase extends RoomDatabase {
    public abstract PessoaDAO getPessoaDAO();
}
