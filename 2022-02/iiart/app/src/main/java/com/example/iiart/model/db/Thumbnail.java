package com.example.iiart.model.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Thumbnail{
    @PrimaryKey
    public int id;
    public String lqip;
    public int width;
    public int height;
    public String altText;
}
