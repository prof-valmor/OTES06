package com.example.exercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HelloActivity.class);
                startActivity(intent);

            }
        });

        Button incrementar = findViewById(R.id.btIncrement);
        ImageButton decrementar = findViewById(R.id.btDecrement);
        TextView txtValor = findViewById(R.id.txtValor);
        incrementar.setOnClickListener(view ->{
            counter++;
            txtValor.setText((counter > 9) ? counter+"" : "0"+counter);
        });
        decrementar.setOnClickListener(view-> {
            if(counter > 0)
                counter--;
            txtValor.setText((counter <= 9) ? "0"+counter : counter+"");
        });
    }
}