package br.udesc.appbase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import br.udesc.appbase.model.Database;

public class MovieListAdapter extends BaseAdapter {

    private final LayoutInflater inflater;

    public MovieListAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }
    @Override
    public int getCount() {
        return Database.getInstance().getMovies().size();
    }

    @Override
    public String getItem(int i) {
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
        ((TextView) linha.findViewById(R.id.name)).setText(getItem(indice));
        return linha;
    }
}
