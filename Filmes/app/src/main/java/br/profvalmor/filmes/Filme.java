package br.profvalmor.filmes;

import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

public class Filme {
    public String titulo;
    public String data;
    public String sinopse;
    public String poster;

    public Filme(String dados) throws JSONException {
        JSONObject json = new JSONObject(dados);

        titulo = json.optString("Title", "titulo fake");
        data   = json.optString("Year", "1960");
        sinopse= json.optString("Plot", "nononononononono");
        poster = json.optString("Poster", null);

    }
    public String toString() {
        return titulo + " \n" + data + "\n" + sinopse + "\n";
    }
}
