package com.example.exercicio7;

import java.util.ArrayList;
import java.util.HashMap;

public class Matriz {
    private String[][] valores;
    public Matriz(int ordem, String conteudo) {
        valores = new String[ordem][ordem];
        for(int i = 0; i < ordem; i++) {
            for(int j = 0; j < ordem; j++){
                valores[i][j] = conteudo;
            }
        }
    }
    public Matriz(Matriz A, Matriz B) {

    }
    public int getOrdem() {
        return valores.length;
    }
    public String get(int linha, int coluna) {
        if(linha >= getOrdem()) return null;
        if(coluna >= getOrdem()) return null;
        return valores[linha][coluna];
    }

    private String[] extrairDiagonalSuperior() {
        ArrayList<String> list = new ArrayList<>();
        for(int linha = 0; linha < getOrdem(); linha++) {
            for (int coluna = 0; coluna < getOrdem(); coluna++) {
                if(coluna >= linha)
                    list.add(valores[linha][coluna]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
    private String[] extrairDiagonalInferior() {
        ArrayList<String> list = new ArrayList<>();
        for(int linha = 0; linha < getOrdem(); linha++) {
            for (int coluna = 0; coluna < getOrdem(); coluna++) {
                if(coluna < linha)
                    list.add(valores[linha][coluna]);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
