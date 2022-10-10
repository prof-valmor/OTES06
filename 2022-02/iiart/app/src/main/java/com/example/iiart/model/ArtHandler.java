package com.example.iiart.model;

import android.util.Log;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ArtHandler {
    private IBuscador buscador;
    /** O arquivista vai observar esta lista de obras de arte... */
    ObservableArrayList<ObraDeArte> listaDeObras = new ObservableArrayList<>();

    public void setBuscador(IBuscador b) {
        buscador = b;
        buscador.getResponse().addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Log.d("Art Handler", "Chegou o dado");
                String json = ((ObservableField<String>)sender).get();
                JsonObject js = JsonParser.parseString(json).getAsJsonObject();
                JsonArray array = js.getAsJsonArray("data");
                for(JsonElement element : array) {
                    element.
                }

            }
        });
    }
}
