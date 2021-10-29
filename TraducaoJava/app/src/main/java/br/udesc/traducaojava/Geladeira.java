package br.udesc.traducaojava;

public class Geladeira {
    private Compartimento compartimentoSuperior;
    private Compartimento compartimentoInferior;

    public Geladeira(Compartimento c1, Compartimento c2) {
        compartimentoSuperior = c1;
        compartimentoInferior = c2;
    }

    public void controlarTemperatura() {
        compartimentoSuperior.controlarTemperatura();
        compartimentoInferior.controlarTemperatura();
    }
    public void setTemperatura(int nivelDaTemperatura) {
        compartimentoSuperior.setTemperatura(nivelDaTemperatura);
        compartimentoInferior.setTemperatura(nivelDaTemperatura);
    }
}
