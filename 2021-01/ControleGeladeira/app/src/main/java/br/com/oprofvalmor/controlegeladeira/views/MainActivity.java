package br.com.oprofvalmor.controlegeladeira.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.oprofvalmor.controlegeladeira.R;
import br.com.oprofvalmor.controlegeladeira.model.Geladeira;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Geladeira geladeira = Geladeira.getInstance();
        Geladeira geladeira1 = Geladeira.getInstance();
        ///
        //Acessar um objeto da tela.
        Button btOkay = findViewById(R.id.btOkay);
        btOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: ");
                Intent intent = new Intent(getApplicationContext(), SelecaoDeTemperatura.class);
                EditText editText = (EditText) findViewById(R.id.edtNome);
                String message = editText.getText().toString();
                intent.putExtra("EXTRA_MESSAGE", message);
                startActivity(intent);
            }
        });
    }
}