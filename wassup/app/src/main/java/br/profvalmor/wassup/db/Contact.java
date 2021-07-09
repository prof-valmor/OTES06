package br.profvalmor.wassup.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @NonNull
    @PrimaryKey
    String name;

    public Contact(String name) {
        this.name = name;
    }

}
