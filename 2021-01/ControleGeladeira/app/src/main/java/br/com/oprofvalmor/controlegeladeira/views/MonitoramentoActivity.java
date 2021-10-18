package br.com.oprofvalmor.controlegeladeira.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.oprofvalmor.controlegeladeira.R;
import br.com.oprofvalmor.controlegeladeira.model.Geladeira;

public class MonitoramentoActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoramento);
        //
        EditText edtText = findViewById(R.id.edtStatus);
        //
        String texto = "C: " + Geladeira.getInstance().getCongelador().getState().name();
        texto += "\n";
        texto += "R: " + Geladeira.getInstance().getRefrigerador().getState().name();
        edtText.setText(texto);

//        Button btBack = findViewById(R.id.btBack);

//        btBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), SelecaoDeTemperatura.class);
//                startActivity(intent);
//            }
//        });
    }
}