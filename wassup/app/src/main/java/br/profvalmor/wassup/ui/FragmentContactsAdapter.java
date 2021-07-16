package br.profvalmor.wassup.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.profvalmor.wassup.R;
import br.profvalmor.wassup.db.Contact;
import br.profvalmor.wassup.db.Database;

public class FragmentContactsAdapter extends BaseAdapter {

    private List<Contact> mValues;
    private LayoutInflater inflater;

    public FragmentContactsAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                mValues = Database.getInstance().getDB().contactDao().getAll();
            }
        };
        (new Thread(r)).start();
    }

    @Override
    public int getCount() {
        if(mValues != null)
            return mValues.size();
        return 0;
    }

    @Override
    public String getItem(int position) {
        return mValues.get(position).getName();
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
