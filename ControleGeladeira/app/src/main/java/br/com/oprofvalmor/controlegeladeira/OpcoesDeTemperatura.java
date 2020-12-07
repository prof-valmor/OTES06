package br.com.oprofvalmor.controlegeladeira;

public enum OpcoesDeTemperatura {
    MINIMA("Mínima"), MEDIA("Média"), MAXIMA("Máxima");

    private String nome;

    OpcoesDeTemperatura(String name) {
        nome = name;
    }

    public String getMeuNome() {
        return nome;
    }

    public static String getNome(int index) {
        try {
            return values()[index].nome;
        }catch (ArrayIndexOutOfBoundsException e) {
            return MEDIA.nome;
        }
    }
}
