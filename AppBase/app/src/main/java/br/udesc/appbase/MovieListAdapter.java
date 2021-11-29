package br.udesc.appbase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.udesc.appbase.model.Database;
import br.udesc.appbase.model.Movie;

public class MovieListAdapter extends BaseAdapter {

    private final LayoutInflater inflater;

    public MovieListAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }
    @Override
    public int getCount() {
        List<Movie> lista = Database.getInstance().getMovies();

        if(lista == null) return 0;
        return lista.size();
    }

    @Override
    public Movie getItem(int i) {
        return Database.getInstance().getMovies().get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int indice, View linha, ViewGroup container) {
        if (linha == null) {
            linha = inflater.inflate(R.layout.layout_movie, container, false);
        }

        ((TextView) linha.findViewById(R.id.movieTitle)).setText(getItem(indice).title);
        return linha;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
