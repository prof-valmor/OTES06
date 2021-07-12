package br.profvalmor.filmes;

import android.graphics.Bitmap;

import org.json.JSONObject;

public class Filme {
    public String titulo;
    public String data;
    public String sinopse;
    public Bitmap poster;

    public Filme(String dados) {
        titulo = dados;
    }
    public String toString() {
        return titulo + " \n" + data + "\n" + sinopse + "\n";
    }
}
