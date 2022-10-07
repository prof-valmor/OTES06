package com.example.iiart.model;

class Arquivo {
    private IBuscador buscador;
    private ArtHandler artHandler = new ArtHandler();
    public void setBuscador(IBuscador b) {
        buscador = b;
        artHandler.setBuscador(b);
    }

    public void procurarObrasComOTema(String tema) {
        buscador.buscarObraPorTema(tema);
    }
}
