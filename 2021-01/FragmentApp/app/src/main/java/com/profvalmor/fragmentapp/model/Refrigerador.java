package com.profvalmor.fragmentapp.model;

/**
 * Write a description of class Refrigerador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Refrigerador {
    protected float temperaturaSelecionada;
    //
    protected Carga ventilador;
    protected SensorDeTemperatura sensorTemperaturaAtual;
    private EstadoDoCompartimento estado = EstadoDoCompartimento.OFF;
    
    public Refrigerador(){
        ventilador = new Carga();
        sensorTemperaturaAtual = new SensorDeTemperatura();
    }

    public EstadoDoCompartimento getState() {
        return estado;
    }
    
    //Setter para temperatura (Celsius).
    public void selecionarTemperatura(float temperatura) {
        temperaturaSelecionada = temperatura;
    }
    
    public void controlarTemperatura() {
        if(sensorTemperaturaAtual.getTemperaturaAtual() > temperaturaSelecionada) {
            estado = EstadoDoCompartimento.GELANDO;
            ventilador.ligar();
        }
        else {
            estado = EstadoDoCompartimento.ESQUENTANDO;
            ventilador.desligar();
        }
    }
}












