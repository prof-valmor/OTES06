package com.example.exercicio7;

public class Printer {

    public static String imprimir(Matriz matriz) {
        int ordem = matriz.getOrdem();
        String output = new String();
        for(int linha = 0; linha < ordem; linha++) {
            for (int coluna = 0; coluna < ordem; coluna++) {
                output+= (" " + matriz.get(linha, coluna));
            }
            output+="\n";
        }
        return output;
    }
}
