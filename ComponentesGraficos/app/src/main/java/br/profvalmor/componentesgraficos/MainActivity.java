package br.profvalmor.componentesgraficos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Button botao = findViewById(R.id.btAdicionar);
        botao.setOnClickListener(this::onClick);

        botao = findViewById(R.id.btDiminuir);
        botao.setOnClickListener(this::onClick);

    }

    private void updateText(int contador) {
        TextView txtContador = findViewById(R.id.txtContador);
        txtContador.setText("CONTADOR vale: " + contador);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btAdicionar) contador++;
        else contador--;

        updateText(contador);
    }
}