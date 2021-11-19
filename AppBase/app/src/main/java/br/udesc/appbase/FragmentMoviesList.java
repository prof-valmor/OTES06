package br.udesc.appbase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentMoviesList extends Fragment {
    public FragmentMoviesList() {
        super(R.layout.fragment_list_of_movies);
    }

    @Override
    public void onStart() {
        super.onStart();
        ListView listView = getView().findViewById(R.id.listMovies);
        listView.setAdapter(new MovieListAdapter(getLayoutInflater()));
    }
}
