package com.example.pokeapi.model;

import android.graphics.Bitmap;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

class PokeApiReader {
    public static MutableLiveData<String> data = new MutableLiveData<>();
    public static MutableLiveData<Bitmap> image = new MutableLiveData<>();

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
    public static void requestImage(int pokemonId) {
        String url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/" +
                "sprites/pokemon/other/official-artwork/" + pokemonId;
//        String url,
//        Response.Listener<Bitmap> listener,
//        int maxWidth,
//        int maxHeight,
//        ImageView.ScaleType scaleType,
//        Bitmap.Config decodeConfig,
//        @Nullable Response.ErrorListener errorListener
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        image.postValue(response);
                    }
                },
                300, 300,
                ImageView.ScaleType.CENTER_CROP,
                Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        image.postValue(null);
                    }
                });
    }
}
