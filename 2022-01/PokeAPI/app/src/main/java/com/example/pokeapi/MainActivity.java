package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.pokeapi.model.Model;
import com.example.pokeapi.model.ModelListener;
import com.example.pokeapi.model.PokemonPOJO;
import com.example.pokeapi.view.FragmentPokemon;
import com.example.pokeapi.view.FragmentSearch;

public class MainActivity extends AppCompatActivity implements ModelListener {
    private FragmentPokemon fragmentPokemon = new FragmentPokemon();
    private FragmentSearch fragmentSearch = new FragmentSearch();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        navegarPara("search");
        //
        Model.getInstance().setListener(this);
    }

    private void navegarPara(String nomeDoFragmento) {
        Fragment f = null;
        if(nomeDoFragmento.equalsIgnoreCase("search")) {
            f = fragmentSearch;
        }
        else if(nomeDoFragmento.equalsIgnoreCase("pokemon")) {
            f = fragmentPokemon;
        }
        if(f != null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.frame, f);
            ft.commit();
        }
    }

    @Override
    public void onPokemonFound(PokemonPOJO pokemon) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
               fragmentPokemon.setPokemonPOJO(pokemon);
               navegarPara("pokemon");
            }
        });
    }

    public void voltar() {
        navegarPara("search");
    }
}