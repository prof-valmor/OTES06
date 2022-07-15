package com.example.pokeapi.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageReader;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import com.example.pokeapi.model.db.DataBase;
import com.example.pokeapi.model.db.Pokemon;

import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;

public class Model implements Observer<String> {
    private static Model instance;
    private DataBase dataBase;
    private Context context;
    private ModelListener listener;
    PokemonPOJO pj =new PokemonPOJO();

    public static Model getInstance() {
        if(instance == null) instance = new Model();
        return instance;
    }
    private Model() {

    }
    public void init(Context context) {
        this.context = context;
        VolleyQueueManager.init(context);
        PokeApiReader.data.observeForever(this);
        PokeApiReader.image.observeForever(new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                updatePojo(bitmap);
                broadcastData();
            }
        });
//        dataBase = Room.databaseBuilder(context,
//                DataBase.class, "pokemon-database").build();
    }

    public void searchPokemon(@NonNull String name) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                doSearch(name.toLowerCase(Locale.ROOT));
            }
        };
        (new Thread(r)).start();
    }

    private void doSearch(String name) {
        PokeApiReader.requestData(name);
//        Pokemon pokemon = dataBase.getPokemonDao().get(name);
//        if(pokemon == null)
//            PokeApiReader.requestData(name);
//        else {
//            updatePojo(pokemon);
//            broadcastData();
//        }

    }

    public void setListener(ModelListener listener) {
        this.listener = listener;
    }

    @Override
    public void onChanged(String s) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Pokemon pokemon = PokemonFactory.create(s);
                //dataBase.getPokemonDao().add(pokemon);
                PokeApiReader.requestImage(pokemon.getId());
                updatePojo(pokemon);
            }
        };
        (new Thread(r)).start();
    }

    private void updatePojo(Pokemon pokemon) {
        pj.name = pokemon.getName();
        pj.height = (int)pokemon.getHeight();
        pj.weight = (int)pokemon.getWeight();
    }
    private void updatePojo(Bitmap img) {
        pj.image = img;
    }

    private void broadcastData() {
        if(listener!=null)
            listener.onPokemonFound(pj);
    }
}
