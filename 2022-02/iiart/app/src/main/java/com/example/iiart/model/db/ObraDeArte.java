package com.example.iiart.model.db;

import android.graphics.Bitmap;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class ObraDeArte {
    @PrimaryKey
    public int id;
    public String titulo;
    public String descricao;
    public String data;
    public String urlFull;
    @Ignore
    public Bitmap imagem;
    @Ignore
    public Thumbnail thumbnail;
}