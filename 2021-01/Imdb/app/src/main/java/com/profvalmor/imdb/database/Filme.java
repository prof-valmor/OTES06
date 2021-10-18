package com.profvalmor.imdb.database;

import android.media.Image;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(primaryKeys = {"nome"})
public class Filme {
    @NonNull
    private String nome;
    private String sinopse;
    private String  cartazUrl;

    public Filme(@NonNull String nome, @NonNull String sinopse, @NonNull  String cartazUrl) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.cartazUrl = cartazUrl;
    }

    public String getNome() {
        return nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getCartazUrl() {
        return cartazUrl;
    }
}
