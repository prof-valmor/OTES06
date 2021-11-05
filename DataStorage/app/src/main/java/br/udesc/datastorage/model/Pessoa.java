package br.udesc.datastorage.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pessoa {
    @PrimaryKey @NonNull
    private String nome;
    private String endereco;

    public Pessoa(@NonNull String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }

    public String toString() {
        return nome;
    }
}
