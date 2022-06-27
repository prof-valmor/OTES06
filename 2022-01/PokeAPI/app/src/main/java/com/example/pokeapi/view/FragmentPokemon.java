package com.example.pokeapi.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pokeapi.R;
import com.example.pokeapi.model.PokemonPOJO;

public class FragmentPokemon extends Fragment {
    PokemonPOJO pokemonPOJO;
    public FragmentPokemon(PokemonPOJO p) {
        super(R.layout.fragment_pokemon);
        this.pokemonPOJO = p;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txt = view.findViewById(R.id.pokemonTxt);
        txt.setText(pokemonPOJO.toString());
    }
}