package com.example.primeiro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.primeiro.model.Cubo;
import com.example.primeiro.model.Extrator;
import com.example.primeiro.model.FiguraGeometrica;
import com.example.primeiro.model.Quadrado;
import com.example.primeiro.model.Retangulo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        TextView txt = findViewById(R.id.txtHello);
        //
        ArrayList<FiguraGeometrica> arrayList = new ArrayList<>(1);
        arrayList.add(new Quadrado(3,3,10));
        arrayList.add(new Cubo(5,3,20));
           arrayList.add(new Retangulo(10,10,10, 100));

        for(FiguraGeometrica fg : arrayList) {
            Log.d("MAIN_ACTIVITY", "area do " + fg.getClass().getSimpleName() + ": " + fg.calcularArea());
        }

            int A [][];
            Extrator ex = new Extrator();
            C = ex.extrairDiagonal();
    }
}