package com.example.exemplolistview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MsgActivity extends Activity {
    private static String [] mensagens = {
      "Ola"
      ,"boa tarde"
      ,"como vai hoje? vamos ter aula amanha?"
      ,"teremos aula sim... mesmo com chuva"
      ,"mesmo com chuva??? :o"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg);
        TextView txt = findViewById(R.id.txtTitulo2);
        // Capturar o intent.
//        Intent i = getIntent();
//        String nome = i.getStringExtra("O_NOME");
//        txt.setText("Olah " + nome);
        ListView list = findViewById(R.id.listaMensagems);
        list.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return mensagens.length;
            }

            @Override
            public String getItem(int i) {
                return mensagens[i];
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if(i%2 == 0) {
                    view = carregaEnviadas(i, view, viewGroup);
                }
                else {
                    view = carregaRecebidas(i, view, viewGroup);
                }
                return view;
            }
        });
    }

    private View carregaEnviadas(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = getLayoutInflater().inflate(R.layout.layout_msg_enviada, viewGroup, false);
        }
        TextView txt = view.findViewById(R.id.txtMensagemEnviada);
        txt.setText(mensagens[i]);

        return view;
    }
    private View carregaRecebidas(int i, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = getLayoutInflater().inflate(R.layout.layout_msg_recebida, viewGroup, false);
        }
        TextView txt = view.findViewById(R.id.txtMensagemRecebida);
        txt.setText(mensagens[i]);

        return view;
    }
}
