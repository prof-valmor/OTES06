package br.profvalmor.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btBuscar = findViewById(R.id.btBuscar);

        DataGetter.getInstance().addListener(new FilmDataListener() {
            @Override
            public void onDataArrived(Filme filme) {
                Log.d("FILME_TAG", "onDataArrived: " + filme);
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataGetter.getInstance().setContext(getApplicationContext());
                DataGetter.getInstance().requestFilmData("the matrix");
            }
        });

    }
}