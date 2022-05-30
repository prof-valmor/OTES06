package com.example.pokeapi.model;

public class Model {
    private static Model instance;
    public static Model getInstance() {
        if(instance == null) instance = new Model();
        return instance;
    }
    private Model() {

    }
    public void init() {
        PokeApiReader.data.observeForever(Parser.getInstance());
    }
}
