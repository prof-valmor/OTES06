package com.example.iiart.model;

import androidx.databinding.ObservableField;

import java.util.Observable;

public interface IBuscador {
    void buscarObraPorTema(String tema);
    ObservableField<String> getResponse();
}
