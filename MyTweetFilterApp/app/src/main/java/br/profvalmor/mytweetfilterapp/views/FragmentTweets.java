package br.profvalmor.mytweetfilterapp.views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import br.profvalmor.mytweetfilterapp.R;

/**
 * A fragment representing a list of Items.
 */
public class FragmentTweets extends Fragment {
    private static final String TAG = FragmentTweets.class.getSimpleName();

    public FragmentTweets() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tweet_list, container, false);

        ListView list = view.findViewById(R.id.listTweets);
        list.setAdapter(new FragmentTweetsAdapter(getLayoutInflater()));

        return view;
    }

}