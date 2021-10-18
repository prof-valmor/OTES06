package br.profvalmor.mytweetfilterapp.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.profvalmor.mytweetfilterapp.R;
import br.profvalmor.mytweetfilterapp.viewmodel.Tweet;

public class FragmentTweetsAdapter extends BaseAdapter {

    private List<Tweet> mValues;
    private LayoutInflater inflater;

    public FragmentTweetsAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        if(mValues != null)
            return mValues.size();
        return 0;
    }

    @Override
    public String getItem(int position) {
        return mValues.get(position).content;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup container) {
        if (view == null) {
            view = inflater.inflate(R.layout.tweet, container, false);
        }
        ((TextView) view.findViewById(R.id.tweetContent)).setText(getItem(position));
        return view;
    }
}
