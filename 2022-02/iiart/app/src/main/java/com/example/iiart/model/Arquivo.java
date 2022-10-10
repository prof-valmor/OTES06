package com.example.iiart.model;

import android.util.Log;

import androidx.databinding.ObservableList;

import java.util.ArrayList;

class Arquivo {
    private IBuscador buscador;
    private ArtHandler artHandler = new ArtHandler();

    public Arquivo() {
        artHandler.listaDeObras.addOnListChangedCallback(new ObservableList.OnListChangedCallback() {
            @Override
            public void onChanged(ObservableList sender) {
                Log.d("ARQUIVO", "onChanged: ");
            }

            @Override
            public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {

            }

            @Override
            public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {

            }

            @Override
            public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {

            }

            @Override
            public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {

            }
        });
    }

    public void setBuscador(IBuscador b) {
        buscador = b;
        artHandler.setBuscador(b);
    }

    public void procurarObrasComOTema(String tema) {
        buscador.buscarObraPorTema(tema);
    }
}
