package br.udesc.cct.donki.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta classe vai saber como buscar as informacoes
 * sobre cada um dos itens disponiveis na API Donki.
 */
public class SpaceWeather {
    private ArrayList<GeomagneticStormObserver> observers;

    public void addGeomagneticStormObserver(GeomagneticStormObserver o) {
        if(!observers.contains(o)) observers.add(o);
    }
    public void removeGeomagneticStormObserver(GeomagneticStormObserver o) {
        if(observers.contains(0)) observers.remove(o);
    }

    public void requestGeomagneticStormData(Date start, Date end) {
        String request = "";
        String prefix = "https://api.nasa.gov/DONKI/GST?";

        if(start != null && end != null) {
            //request += "startDate="+start.getTime() +"&endDate=2016-01-30";
        }
        request += "&api_key=HKMoEi0nVgCMuCJCuV87MOLI31c2DbJShQ1AnpUg";
    }
    public void requestGeomagneticStormData() {
        this.requestGeomagneticStormData(null, null);
    }
}
