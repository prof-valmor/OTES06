package br.udesc.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;

import br.udesc.datastorage.model.GerenciadorDeDados;
import br.udesc.datastorage.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btSalvar = findViewById(R.id.btSalvar);
        Button btLimpar = findViewById(R.id.btLimpar);
        btLimpar.setOnClickListener(view -> {
            EditText edtNome = findViewById(R.id.edtNome);
            edtNome.setText("");
        });
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNome = findViewById(R.id.edtNome);
                String nome = edtNome.getText().toString();
                if(!nome.isEmpty()) {
                    Pessoa p = new Pessoa(nome);
                    try {
                        GerenciadorDeDados.getInstance().armazenarPessoaEmArquivo(getApplicationContext(), p);
                    }
                    catch(FileNotFoundException e) {
                        Log.d(TAG, "onClick: nao foi possivel armazenar. " + e.getMessage());
                    }
                }
            }
        });
    }
}