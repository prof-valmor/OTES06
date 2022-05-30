package com.example.pokeapi.model;

import androidx.lifecycle.Observer;
import com.google.gson.JsonObject;

public class Parser implements Observer<String> {
    private static Parser instance;

    private Parser() {

    }

    public static Parser getInstance() {
        if(instance == null) instance = new Parser();
        return instance;
    }

    @Override
    public void onChanged(String s) {
        JsonObject js = new JsonObject().getAsJsonObject(s);
    }
}
