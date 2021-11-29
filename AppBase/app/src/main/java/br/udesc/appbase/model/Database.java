package br.udesc.appbase.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.udesc.appbase.model.cloud.CloudManager;
import br.udesc.appbase.model.cloud.SearchResultListener;

public class Database implements SearchResultListener {
    private static Database instance;
    private String movieSelected;

    private List<Movie> movieList;

    private DBListener listener;

    private Database() {
        CloudManager.getInstance().setSearchResultListener(this);
    }
    public static Database getInstance() {
        if(instance == null) instance = new Database();
        return instance;
    }
    public List<Movie> getMovies() {
        return movieList;
    }

    public void setDBListener(DBListener listener_) {
        listener = listener_;
    }

    public void searchMovieBy(String word) {
        CloudManager.getInstance().searchByWord(word);
    }

    public void setSelected(String movie) {
        this.movieSelected = movie;
    }

    public String getSelected() {
        return this.movieSelected;
    }

    @Override
    public void onSearchResult(List<String> list) {
//        movieList = list;
        try {
            movieList = convertJsonToMovie(list);
        } catch (JSONException e) {
            e.printStackTrace();
            movieList = null;
        }

        if(listener != null) {
            listener.onMovieListUpdated();
        }
    }

    private List<Movie> convertJsonToMovie(List<String> listaJSON) throws JSONException {
        ArrayList<Movie> lista = new ArrayList<>(listaJSON.size());
        for(String elemento : listaJSON) {
            JSONObject obj = new JSONObject(elemento);
            Movie m = new Movie();
            m.title = obj.getString("Title");
            m.year = obj.getString("Year");
            m.id = obj.getString("imdbID");
            m.type = obj.getString("Type");
            //...
            lista.add(m);
        }
        return lista;
    }
}
