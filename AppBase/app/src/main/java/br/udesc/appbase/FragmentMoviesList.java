package br.udesc.appbase;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import br.udesc.appbase.model.DBListener;
import br.udesc.appbase.model.Database;
import br.udesc.appbase.model.cloud.CloudManager;

public class FragmentMoviesList extends Fragment {
    public FragmentMoviesList() {
        super(R.layout.fragment_list_of_movies);
    }

    @Override
    public void onStart() {
        super.onStart();
        CloudManager.getInstance().createQueue(getContext());

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

        Database.getInstance().setDBListener(new DBListener() {
            @Override
            public void onMovieListUpdated() {
                listView.invalidateViews();
            }
        });
        //
        Button btPequisar = getView().findViewById(R.id.btPesquisar);
        EditText edtWord = getView().findViewById(R.id.edtWhatToSearch);
        btPequisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database.getInstance().searchMovieBy(edtWord.getText().toString());
            }
        });
    }
}
