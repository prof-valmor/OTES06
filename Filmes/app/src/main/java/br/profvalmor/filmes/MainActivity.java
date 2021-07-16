package br.profvalmor.filmes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btBuscar = findViewById(R.id.btBuscar);
        Button btClean = findViewById(R.id.btClean);

        DataGetter.getInstance().addFilmDataListener(new FilmDataListener() {
            @Override
            public void onDataArrived(Filme filme) {
                TextView txt = findViewById(R.id.txtInfo);
                txt.setText(filme.toString());
                //
                if(filme.poster != null) {
                    DataGetter.getInstance().requestPoster(filme.poster);
                }
            }
        });

        DataGetter.getInstance().addPosterListener(new PosterListener() {
            @Override
            public void onPosterArrived(Bitmap image) {
                ImageView img = findViewById(R.id.imgPoster);
                img.setImageBitmap(image);
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edt = findViewById(R.id.edtNomeFilme);
                DataGetter.getInstance().setContext(getApplicationContext());
                DataGetter.getInstance().requestFilmData(edt.getText().toString());
            }
        });
        btClean.setOnClickListener(v -> {
            EditText edt = findViewById(R.id.edtNomeFilme);
            edt.setText("");
            TextView txt = findViewById(R.id.txtInfo);
            txt.setText("");
            ImageView img = findViewById(R.id.imgPoster);
            img.setImageBitmap(null);
        });
    }
}