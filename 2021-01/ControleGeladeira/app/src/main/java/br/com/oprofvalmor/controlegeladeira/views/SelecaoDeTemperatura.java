package br.com.oprofvalmor.controlegeladeira.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import br.com.oprofvalmor.controlegeladeira.R;
import br.com.oprofvalmor.controlegeladeira.model.Geladeira;

public class SelecaoDeTemperatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_de_temperatura);

        SeekBar sbTemperature = findViewById(R.id.sbTemperature);
        Button  btNext = findViewById(R.id.btNext);
        TextView txtTemperature = findViewById(R.id.txtTemperature);
        txtTemperature.setText(OpcoesDeTemperatura.MEDIA.getMeuNome());

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MonitoramentoActivity.class);
                startActivity(intent);
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