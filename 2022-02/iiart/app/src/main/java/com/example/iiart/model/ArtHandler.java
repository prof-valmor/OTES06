package com.example.iiart.model;

import android.util.Log;

import androidx.databinding.Observable;

public class ArtHandler {
    private IBuscador buscador;
    public void setBuscador(IBuscador b) {
        buscador = b;
        buscador.getResponse().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("Art Handler", "Chegou o dado");
            }
        });
    }
}