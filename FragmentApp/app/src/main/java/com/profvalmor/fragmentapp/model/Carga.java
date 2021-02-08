package com.profvalmor.fragmentapp.model;

/**
 * Representa um componente eletronico que eh acionado durante o 
 * controle de temperatura.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Carga {
    private boolean ligado;
    public Carga() {
        ligado = false;
    }
    
    public void ligar() {
        ligado = true;
    }
    
    public void desligar() {
        ligado = false;
    }
    
    public boolean estahLigado() {
        return ligado;
    }
}
