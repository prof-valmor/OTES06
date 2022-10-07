package com.example.iiart.model;

public class Galeria {
    private static Galeria instance;
    private Arquivo arquivo;
    private Galeria() {
        arquivo = new Arquivo();

    }
    public static Galeria getInstance(){
        if(instance == null) instance = new Galeria();
        return instance;
    }
    //
    public void procurarObrasCom(String tema) {
        arquivo.procurarObrasComOTema(tema);
    }

    public void defineBuscador(IBuscador b) {
        arquivo.setBuscador(b);
    }
}
