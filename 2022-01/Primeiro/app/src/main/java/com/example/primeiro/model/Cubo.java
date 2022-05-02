package com.example.primeiro.model;

public class Cubo extends Quadrado {
    public Cubo(int x_, int y_, int lado_) {
        super(x_, y_, lado_);
    }

    @Override
    public int calcularArea() {
        return super.calcularArea()*6;
    }
}
