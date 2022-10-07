package com.example.iiart.view;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.iiart.R;

public class Listing extends Fragment {
    private String[] dados = new String[]{"valmor","joao", "mario", "dussman", "renan", "vinicius", "eduardo",
                                          "valmor1","joao1", "mario1", "dussman1", "renan1", "vinicius1", "eduardo1"};

    public Listing() {
        super(R.layout.fragment_listing);
    }

    @Override
    public void onStart() {
        super.onStart();
        ListView lista = getActivity().findViewById(R.id.listaObras);
        lista.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return dados.length;
            }

            @Override
            public String getItem(int i) {
                return dados[i];
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if(view == null) {
                    view = getLayoutInflater().inflate(R.layout.layout_linha, viewGroup, false);
                }

                TextView temp = view.findViewById(R.id.txtPrincipal);
                temp.setText(dados[i]);

                return view;
            }
        });
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.setAction("navegar");
                intent.putExtra("qual", "home");
                getActivity().sendBroadcast(intent);
            }
        });
    }
}
