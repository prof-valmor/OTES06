package com.example.pokeapi.model;

import androidx.lifecycle.Observer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class Parser implements Observer<String> {
    private static Parser instance;
    private Pokemon currentPokemon;

    private Parser() {

    }

    public static Parser getInstance() {
        if(instance == null) instance = new Parser();
        return instance;
    }

    @Override
    public void onChanged(String s) {
        currentPokemon = new Pokemon();
        JsonObject js = JsonParser.parseString(s).getAsJsonObject();
        currentPokemon.height = js.getAsJsonPrimitive("height").getAsInt();
        currentPokemon.weight = 0;
        if(js.has("weight")) {
            currentPokemon.weight = js.getAsJsonPrimitive("weight").getAsInt();
        }
        if(js.has("sprites")) {
            JsonObject sprites = js.getAsJsonObject("sprites");
            if(sprites.has("official-artwork")) {
                JsonObject artwork = sprites.getAsJsonObject("official-artwork");
                if(artwork.has("front_default")) {
                    currentPokemon.url = artwork.getAsJsonPrimitive("front_default").getAsString();
                }
            }
        }
    }
}
