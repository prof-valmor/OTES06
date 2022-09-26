package com.example.iiart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.iiart.model.Curador;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Curador.getInstance().procurarObrasCom("cats");
    }
}