package com.example.iiart.model.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ObraDeArte.class, Thumbnail.class}, version = 1)
public abstract class BancoDeObras extends RoomDatabase {
    public abstract ObraDeArteDAO getObraDeArteDAO();
}
