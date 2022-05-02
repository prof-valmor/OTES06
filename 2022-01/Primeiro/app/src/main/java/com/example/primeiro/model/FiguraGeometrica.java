package com.example.primeiro.model;

public abstract class FiguraGeometrica {
    private int x;
    private int y;

    public FiguraGeometrica(int x_, int y_) {
        x = x_;
        y = y_;
    }
    public abstract  int calcularArea();
}
