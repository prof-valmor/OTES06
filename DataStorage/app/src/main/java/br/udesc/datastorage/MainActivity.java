package br.udesc.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import br.udesc.datastorage.model.GerenciadorDeDados;
import br.udesc.datastorage.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criando o DB
        GerenciadorDeDados.getInstance().initDatabase(getApplicationContext());
        //
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
                //
                Pessoa novaPessoa = new Pessoa(nome, "ficticio nr 200");
                if(!nome.isEmpty()) {
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            GerenciadorDeDados.getInstance().getDatabase().getPessoaDAO().add(novaPessoa);
                        }
                    };
                    new Thread(r).start();
                }
            }
        });

        initTask();
    }
    private void initTask() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                List<Pessoa> lista = GerenciadorDeDados.getInstance().getDatabase().getPessoaDAO().getAll();
                for(Pessoa p : lista) {
                    Log.d(TAG, "PESSOA: " + p);
                }
            }
        }, 0, 1000);
    }
}