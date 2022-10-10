package com.example.iiart.model;

import android.util.Log;

import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;

import com.example.iiart.model.db.MeuBanco;
import com.example.iiart.model.db.ObraDeArte;
import com.example.iiart.model.db.Thumbnail;
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
                Runnable r = new Runnable() {
                    @Override
                    public void run() {
                        JsonObject js = JsonParser.parseString(json).getAsJsonObject();
                        JsonArray array = js.getAsJsonArray("data");
                        ObraDeArte obra;
                        Thumbnail thumbnail;
                        JsonObject jsonObject;
                        JsonObject jsThumbnail;
                        for (JsonElement element : array) {
                            Log.d("ART_HANDLER", element.toString());
                            jsonObject = element.getAsJsonObject();
                            obra = new ObraDeArte();
                            obra.urlFull = jsonObject.get("api_link").getAsString();
                            obra.titulo = jsonObject.get("title").getAsString();
                            obra.id = jsonObject.get("id").getAsInt();
                            thumbnail = new Thumbnail();
                            jsThumbnail = jsonObject.get("thumbnail").getAsJsonObject();
                            thumbnail.id = obra.id;
                            thumbnail.altText = jsThumbnail.get("alt_text").getAsString();
                            thumbnail.width = jsThumbnail.get("width").getAsInt();
                            thumbnail.height = jsThumbnail.get("height").getAsInt();
                            thumbnail.lqip = jsThumbnail.get("lqip").getAsString();
                            //
                            obra.thumbnail = thumbnail;
                            listaDeObras.add(obra);
                            MeuBanco.getInstance().getBanco().getObraDeArteDAO().add(obra);
                        }
                    }
                };
                Thread t = new Thread(r);
                t.start();
//                listaDeObras.
            }
        });
    }
}
