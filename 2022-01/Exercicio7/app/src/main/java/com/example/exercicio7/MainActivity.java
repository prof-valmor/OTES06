package com.example.exercicio7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txt = findViewById(R.id.texto);        ///
        Matriz A = new Matriz(3, "A");
        Matriz B = new Matriz(3, "B");
        String a = Printer.imprimir(A);
        a += Printer.imprimir(B);
        txt.setText(a);
        //Printer.imprimir(B);
    }
}