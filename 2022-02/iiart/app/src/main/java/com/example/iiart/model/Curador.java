package com.example.iiart.model;

public class Curador {
    private static Curador instance;
    private Arquivista arquivista;
    private Curador() {
        arquivista = new Arquivista();

    }
    public static Curador getInstance(){
        if(instance == null) instance = new Curador();
        return instance;
    }
    //
    public void procurarObrasCom(String tema) {
        arquivista.procurarObrasComOTema(tema);
    }

    public void defineBuscador(IBuscador b) {
        arquivista.setBuscador(b);
    }
}
