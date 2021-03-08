package br.profvalmor.examplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        ListView lista = findViewById(R.id.listUsuarios);

        lista.setAdapter(new MessageAdapter(this));
    }

}