package com.example.pokeapi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.pokeapi.R;
import com.example.pokeapi.model.PokeApiReader;

import java.util.Observable;

public class FragmentSearch extends Fragment {
    public FragmentSearch() {
        super(R.layout.fragment_search);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PokeApiReader.data.observeForever(new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView text = getActivity().findViewById(R.id.temporario);
                text.setText(s.substring(0, 150));
            }
        });
        Button btSearch = getActivity().findViewById(R.id.btSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PokeApiReader.requestData("pikachu");
            }
        });
    }
}
