package com.example.primeiro.model;

public class Retangulo extends Quadrado {
    private int base;

    public Retangulo(int x_, int y_, int altura_, int base_) {
        super(x_, y_, altura_);
        base = base_;
    }

    @Override
    public int calcularArea() {
        return super.getLado()*base;
    }
}
