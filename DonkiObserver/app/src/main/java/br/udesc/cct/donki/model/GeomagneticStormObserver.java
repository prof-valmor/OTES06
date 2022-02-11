package br.udesc.cct.donki.model;

public interface GeomagneticStormObserver {
    void onGeomagneticStormDataReady(String jsonData);
}
