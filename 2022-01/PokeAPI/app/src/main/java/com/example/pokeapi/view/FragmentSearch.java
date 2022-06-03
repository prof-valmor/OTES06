package com.example.pokeapi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pokeapi.R;


import java.util.Observable;

public class FragmentSearch extends Fragment {
    public FragmentSearch() {
        super(R.layout.fragment_search);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button btSearch = getActivity().findViewById(R.id.btSearch);
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
