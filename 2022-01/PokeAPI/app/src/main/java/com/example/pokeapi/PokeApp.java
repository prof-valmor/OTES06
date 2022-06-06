package com.example.pokeapi;

import android.app.Application;

import com.example.pokeapi.model.Model;

public class PokeApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Model.getInstance().init(getApplicationContext());
    }
}
