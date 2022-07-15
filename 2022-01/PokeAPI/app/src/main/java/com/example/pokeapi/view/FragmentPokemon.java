package com.example.pokeapi.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokeapi.MainActivity;
import com.example.pokeapi.R;
import com.example.pokeapi.model.PokemonPOJO;

public class FragmentPokemon extends Fragment {
    PokemonPOJO pokemonPOJO;

    public FragmentPokemon() {
        super(R.layout.fragment_pokemon);
    }

    public void setPokemonPOJO(PokemonPOJO pokemonPOJO) {
        this.pokemonPOJO = pokemonPOJO;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView iv = view.findViewById(R.id.imageView);
        iv.setImageBitmap(this.pokemonPOJO.image);
        //
        Button btVoltar = view.findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).voltar();
            }
        });
    }
}