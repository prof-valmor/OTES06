package br.profvalmor.wassup.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.profvalmor.wassup.R;

public class FragmentContactsAdapter extends BaseAdapter {

    private final List<String> mValues;
    private LayoutInflater inflater;

    public FragmentContactsAdapter(LayoutInflater inflater) {
        this.inflater = inflater;

        ArrayList<String> lista = new ArrayList<>(1);
        for (int i = 0; i < 100; i++) {
            lista.add(List.class.getName() + "# " + i);
        }
        mValues = lista;
    }

    @Override
    public int getCount() {
        return mValues.size();
    }

    @Override
    public String getItem(int position) {
        return mValues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup container) {
        if (view == null) {
            view = inflater.inflate(R.layout.contacts_line, container, false);
        }
        ((TextView) view.findViewById(R.id.nameContact)).setText(getItem(position));
        return view;
    }
}
