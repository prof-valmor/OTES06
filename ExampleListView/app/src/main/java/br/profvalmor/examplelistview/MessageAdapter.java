package br.profvalmor.examplelistview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {

    private final Activity activity;
    private class Mensagem {
        public Mensagem(String sender, String texto) {
            this.sender = sender;
            this.texto = texto;
        }
        public String sender;
        public String texto;
    }
    private ArrayList<Mensagem> array = new ArrayList<>(1);

    public MessageAdapter(Activity activity) {
        this.activity = activity;
        array.add(new Mensagem("valmor", "bom dia, como vai?"));
        array.add(new Mensagem("igor"  , "opa, vou bem obrigado."));
        array.add(new Mensagem("valmor", "e o jogo, como foi?"));
        array.add(new Mensagem("igor"  , "nao fui, estou respeitando o afastamento"));
        array.add(new Mensagem("valmor", "interessante, certo vc"));
        array.add(new Mensagem("igor"  , "muito bem."));
        array.add(new Mensagem("valmor", "e amanham"));
        array.add(new Mensagem("igor"  , "feriado."));
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup container) {
        String user;
        String texto;
        user  = array.get(position).sender;
        texto = array.get(position).texto;

        if (convertView == null) {
            if(user.equalsIgnoreCase("valmor")) {
                convertView = activity.getLayoutInflater().inflate(R.layout.linha_mensagem, container, false);
            }
            else {
                convertView = activity.getLayoutInflater().inflate(R.layout.linha_mensagem_outro, container, false);
            }
        }

        ((TextView) convertView.findViewById(R.id.txtMensagem))
                .setText(texto);
        return convertView;
    }
}
