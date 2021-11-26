package br.udesc.appbase;

import android.widget.TextView;

import androidx.fragment.app.Fragment;

import br.udesc.appbase.model.Database;

public class FragmentMovie extends Fragment {
    public FragmentMovie() {
        super(R.layout.fragment_movie);
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView text = getView().findViewById(R.id.title);
        text.setText(Database.getInstance().getSelected());
    }
}
