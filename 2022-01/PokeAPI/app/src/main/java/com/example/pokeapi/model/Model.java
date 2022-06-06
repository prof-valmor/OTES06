package com.example.pokeapi.model;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import com.example.pokeapi.model.db.DataBase;
import com.example.pokeapi.model.db.Pokemon;

public class Model implements Observer<String> {
    private static Model instance;
    private DataBase dataBase;

    public static Model getInstance() {
        if(instance == null) instance = new Model();
        return instance;
    }
    private Model() {

    }
    public void init(Context context) {
        VolleyQueueManager.init(context);
        PokeApiReader.data.observeForever(this);
        dataBase = Room.databaseBuilder(context,
                DataBase.class, "pokemon-database").build();
    }

    public void searchPokemon(@NonNull String name) {
        PokeApiReader.requestData(name);
    }
    @Override
    public void onChanged(String s) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Pokemon pokemon = PokemonFactory.create(s);
                dataBase.getPokemonDao().add(pokemon);
                Log.d("runnn", "run: funcionou");
            }
        };
        (new Thread(r)).start();

    }
}
