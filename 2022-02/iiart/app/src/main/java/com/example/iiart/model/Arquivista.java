package com.example.iiart.model;

class Arquivista {
    private static IBuscador buscador;


    public static void setBuscador(IBuscador b) {
        buscador = b;
    }

    public static void procurarObrasComOTema(String tema) {
        buscador.buscarObraPorTema(tema);
    }
}
