package com.example.pokeapi.model;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class PokeApiReader {
    public static MutableLiveData<String> data = new MutableLiveData<>();

    public static void requestData(String pokemonName) {
        String url = "https://pokeapi.co/api/v2/pokemon/"+pokemonName;
        StringRequest request = new StringRequest(Request.Method.GET, url,
        (String response) -> {
                data.postValue(response);
        },
        (VolleyError error)-> {
                data.postValue(error.getMessage());
            }
        );
        VolleyQueueManager.addToQueue(request);

    }
}
