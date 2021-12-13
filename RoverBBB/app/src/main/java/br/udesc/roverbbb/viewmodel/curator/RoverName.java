package br.udesc.roverbbb.viewmodel.curator;

public enum RoverName {
    CURIOSITY("curiosity"),
    OPPORTUNITY("opportunity"),
    SPIRITY("spirity");

    String name;
    RoverName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
