package com.profvalmor.fragmentapp.views;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.profvalmor.fragmentapp.R;
import com.profvalmor.fragmentapp.model.Geladeira;

public class SelecaoDeTemperaturaFragment extends Fragment {

    public SelecaoDeTemperaturaFragment(){
        super(R.layout.activity_selecao_de_temperatura);
    }
    @Override
    public void onStart() {
        super.onStart();

        SeekBar sbTemperature = getView().findViewById(R.id.sbTemperature);
        Button  btNext = getActivity().findViewById(R.id.btNext);
        TextView txtTemperature = getActivity().findViewById(R.id.txtTemperature);
        txtTemperature.setText(OpcoesDeTemperatura.MEDIA.getMeuNome());

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        sbTemperature.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int p = seekBar.getProgress();
                txtTemperature.setText(OpcoesDeTemperatura.getNome(p));
                //Alterando a temperatura da geladeira.
                Geladeira.getInstance().selecionarTemperatura(p);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}