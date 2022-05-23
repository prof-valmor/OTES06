package com.example.pokeapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.pokeapi.model.VolleyQueueManager;

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
                String url = "https://pokeapi.co/api/v2/pokemon/pikachu";
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TextView tv = getActivity().findViewById(R.id.temporario);
                        tv.setText(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        TextView tv = getActivity().findViewById(R.id.temporario);
                        tv.setText(error.getMessage());
                    }
                });
                VolleyQueueManager.addToQueue(request);
            }
        });
    }
}
