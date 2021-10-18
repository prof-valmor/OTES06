package br.com.oprofvalmor.controlegeladeira.model;

/**
 * Representa uma Geladeira conforme o exercicio #1 da Lista #1.
 * Design Pattern: Singleton.
 *
 * @author adami
 * @version 0.1
 */
public class Geladeira {
    //Implementando Singleton:
    private final static Geladeira instance = new Geladeira();
    //
    public static Geladeira getInstance() {
        return instance;
    }

    private int nivelDaTemperatura;
    private Congelador   congelador;
    private Refrigerador refrigerador; 
    
    private Geladeira() {
        nivelDaTemperatura = 0; //0 eh o minimo.
        //instanciar os componentes.
        congelador = new Congelador();
        refrigerador = new Refrigerador();
    }
    
    //Setter o valor para o nivelDaTemperatura.
    public void selecionarTemperatura(int nivel) {
        nivelDaTemperatura = nivel;
        refrigerador.selecionarTemperatura((nivel+1) * 5);
        congelador.selecionarTemperatura((nivel+1) * - 10);
    }
    //
    public void controlarTemperatura() {
        congelador.controlarTemperatura();
        refrigerador.controlarTemperatura();
    }

    public Congelador getCongelador() {
        return congelador;
    }

    public Refrigerador getRefrigerador() {
        return refrigerador;
    }
}
