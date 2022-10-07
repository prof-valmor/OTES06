package com.example.iiart.model.conn;

import android.util.Log;

import androidx.databinding.ObservableField;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.iiart.model.IBuscador;

public class Buscador implements IBuscador {
    private static final String urlBase = "https://api.artic.edu/api/v1/artworks/search?q=";
    private static final String urlImagemPrefix = "https://www.artic.edu/iiif/2/";
    private static final String urlImagemMid    = "/full/";
    private static final String urlImagemSufix = ",/0/default.jpg";

    private ObservableField<String> jsonWithPieces = new ObservableField<>();

//    public static void buscarImagem(String imageId, int pieceId) {
//        String url = urlImagemPrefix + imageId + urlImagemMid + pieceId + urlImagemSufix;
//        //todo usar a url.
//    }

    @Override
    public void buscarObraPorTema(String tema) {
        String url = urlBase + tema;
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        jsonWithPieces.set(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("BUSCADOR", "onErrorResponse: ");
                    }
                });
        QueueManager.addToQueue(request);
    }

    @Override
    public ObservableField<String> getResponse() {
        return jsonWithPieces;
    }
}
