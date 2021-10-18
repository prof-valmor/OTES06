package br.udesc.simpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = findViewById(R.id.btIr);
        bt.setOnClickListener(view -> {
            Log.d(TAG, "Clicando no botao IR!");
            Intent intent = new Intent(this, HelloActivity.class);
            intent.putExtra("TEXTO", "MOSTRAR ESTE TEXTO NA TELA 2.");
            startActivity(intent);
        });

    }
}