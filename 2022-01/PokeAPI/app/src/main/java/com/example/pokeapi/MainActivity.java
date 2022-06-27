package com.example.pokeapi;

import androidx.appcompat.app.AppCompatActivity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame, new FragmentSearch());
        ft.commit();
        //
        Model.getInstance().setListener(this);
    }

    @Override
    public void onPokemonFound(PokemonPOJO pokemon) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame, new FragmentPokemon(pokemon));
                ft.commit();
            }
        });
    }
}