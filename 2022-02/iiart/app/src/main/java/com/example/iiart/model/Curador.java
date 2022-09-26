package com.example.iiart.model;

public class Curador {
    private static Curador instance;
    private Curador() {

    }
    public static Curador getInstance(){
        if(instance == null) instance = new Curador();
        return instance;
    }
    //
    public void procurarObrasCom(String tema) {
        Arquivista.procurarObrasComOTema(tema);
    }
}
