package com.example.pokeapi.model;

import com.example.pokeapi.model.db.Pokemon;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class PokemonFactory {
    public static Pokemon create(String s) {
        JsonObject js = JsonParser.parseString(s).getAsJsonObject();
        //??
        String name = js.get("name").getAsString();
        double w    = js.get("weight").getAsDouble();
        double h    = js.get("height").getAsDouble();
        int id      = js.get("id").getAsInt();
        String path = "";
        return new Pokemon(name, w, h, id);
    }
}
