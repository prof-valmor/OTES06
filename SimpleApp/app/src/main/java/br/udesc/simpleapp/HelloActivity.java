package br.udesc.simpleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelloActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        Intent intent = getIntent();
        String message = intent.getStringExtra("TEXTO");
        //
        TextView texto = findViewById(R.id.txtHello);
        texto.setText(message);
    }
}
