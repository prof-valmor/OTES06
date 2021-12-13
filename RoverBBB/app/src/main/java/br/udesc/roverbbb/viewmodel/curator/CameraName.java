package br.udesc.roverbbb.viewmodel.curator;

public enum CameraName {
    FHAZ("fhaz"),
    RHAZ("rhaz"),
    MAST("mast"),
    CHEMCAM("chemcam"),
    MAHLI("mahli"),
    MARDI("mardi"),
    NAVCAM("navcam"),
    PANCAM("pancam"),
    MINITES("minites");

    String name;
    CameraName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
