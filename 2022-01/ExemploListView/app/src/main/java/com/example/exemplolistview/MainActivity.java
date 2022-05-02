package com.example.exemplolistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static String [] nomes = new String[] {"valmor",
            "felipe", "james", "luiza", "felipe2", "james2", "luiza2",
            "felipe3", "james3", "luiza3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = findViewById(R.id.listaUsuarios);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return nomes.length;
            }

            @Override
            public String getItem(int i) {
                return nomes[i];
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null) {
                    view = getLayoutInflater().inflate(R.layout.layout_linha, viewGroup, false);
                }

                TextView temp = view.findViewById(R.id.txtPrincipal);
                temp.setText(nomes[i]);

                return view;
            }
        });
    }
}