package com.example.iiart.model.db;

import android.content.Context;

import androidx.room.Room;

public class MeuBanco {
    private static MeuBanco instance;
    private BancoDeObras db;

    public static MeuBanco getInstance() {
        if(instance == null) {
            instance = new MeuBanco();
        }
        return instance;
    }
    private MeuBanco() {

    }
    public void init(Context c) {
        db = Room.databaseBuilder(c,
                BancoDeObras.class, "database-iiart").build();
    }
    public BancoDeObras getBanco() {
        return db;
    }
}
