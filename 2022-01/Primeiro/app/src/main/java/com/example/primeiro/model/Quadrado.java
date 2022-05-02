package com.example.primeiro.model;

public class Quadrado extends FiguraGeometrica {
    private int lado;

    public Quadrado(int x_, int y_, int lado_) {
        super(x_, y_);
        lado = lado_;
    }
    public int getLado() {
        return lado;
    }

    @Override
    public int calcularArea() {
        return lado*lado;
    }
}
