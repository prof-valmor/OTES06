package com.example.pokeapi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.pokeapi.R;
import com.example.pokeapi.model.Model;


public class FragmentSearch extends Fragment implements View.OnClickListener {
    public FragmentSearch() {
        super(R.layout.fragment_search);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btSearch = getActivity().findViewById(R.id.btSearch);
        btSearch.setOnClickListener(this);
        Button btClear = getActivity().findViewById(R.id.btClear);
        btClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        EditText edit = getActivity().findViewById(R.id.edtPokemonName);
        if(view.getId() == R.id.btSearch) {
            Model.getInstance().searchPokemon(edit.getText() + "");
        }
        else if(view.getId() == R.id.btClear) {
            edit.setText("");
        }
    }
}
