package com.profvalmor.fragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.profvalmor.fragmentapp.views.HomeFragment;
import com.profvalmor.fragmentapp.views.MonitoramentoFragment;
import com.profvalmor.fragmentapp.views.SelecaoDeTemperaturaFragment;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int indice, boolean b) {
               navegarParaOutroFragmento(indice);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        navegarParaOutroFragmento(0);
    }

    private void navegarParaOutroFragmento(int indice) {
        Fragment fragment = null;
        switch (indice) {
            case 0:
                Log.d("MAIN", "INDICE 0");
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new MonitoramentoFragment();
                Log.d("MAIN", "INDICE UM");
                break;
            case 2:
                fragment = new SelecaoDeTemperaturaFragment();
                Log.d("MAIN", "INDICE DOIS");
                break;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
}