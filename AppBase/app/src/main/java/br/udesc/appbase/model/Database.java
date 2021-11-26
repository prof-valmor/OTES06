package br.udesc.appbase.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance;
    private String movieSelected;

    private Database() {

    }

    public static Database getInstance() {
        if(instance == null) instance = new Database();
        return instance;
    }

    public List<String> getMovies() {
        ArrayList<String> list = new ArrayList<>();
        list.add("The Matrix");
        list.add("Avengers"  );
        list.add("Red Alert" );
        list.add("Jungle Cruise" );
        return list;
    }

    public void setSelected(String movie) {
        this.movieSelected = movie;
    }

    public String getSelected() {
        return this.movieSelected;
    }
}
