package br.udesc.appbase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MovieListAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    //teste
    String [] listaFilmes = new String[]{"The Matrix", "Avengers", "Red Alert"};

    public MovieListAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }
    @Override
    public int getCount() {
        return listaFilmes.length;
    }

    @Override
    public String getItem(int i) {
        return listaFilmes[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int indice, View view, ViewGroup container) {
        if (view == null) {
            view = inflater.inflate(R.layout.layout_movie, container, false);
        }
        ((TextView) view.findViewById(R.id.name)).setText(getItem(indice));
        return view;
    }
}
