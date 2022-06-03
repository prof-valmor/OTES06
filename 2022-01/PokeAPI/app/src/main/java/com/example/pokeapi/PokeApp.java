package com.example.pokeapi;

import android.app.Application;

import com.example.pokeapi.model.Model;
import com.example.pokeapi.model.VolleyQueueManager;

public class PokeApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        VolleyQueueManager.init(getApplicationContext());

        Model.getInstance().init();

    }
}
