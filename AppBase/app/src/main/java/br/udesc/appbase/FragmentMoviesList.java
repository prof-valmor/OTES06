package br.udesc.appbase;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import br.udesc.appbase.model.Database;

public class FragmentMoviesList extends Fragment {
    public FragmentMoviesList() {
        super(R.layout.fragment_list_of_movies);
    }

    @Override
    public void onStart() {
        super.onStart();
        ListView listView = getView().findViewById(R.id.listMovies);
        listView.setAdapter(new MovieListAdapter(getLayoutInflater()));
        //
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View linha, int i, long l) {
                ((MainActivity)getActivity()).navigateTo(FragmentMovie.class.getSimpleName());
                Database.getInstance().setSelected(linha.toString());
            }
        });
    }
}
