package com.profvalmor.fragmentapp.model;

/**
 * Write a description of class Congelador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Congelador extends Refrigerador{
    private Carga compressor;

    public Congelador() {
        super(); //chamando o construtor da classe mae.
        compressor = new Carga();
    }

    public void controlarTemperatura() {
        super.controlarTemperatura();
        if(ventilador.estahLigado()) {
            compressor.ligar();
        }
        else{
            compressor.desligar();
        }
    }  
}
