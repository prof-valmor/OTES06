package br.profvalmor.filmes;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class DataGetter {
    private static DataGetter instance;
    private Context context;
    private ArrayList<FilmDataListener> listeners = new ArrayList<>(1);
    private static final String apiKeyPrefix = "&apikey=130637f6";
    private static final String apiKeySuffix = "&";
    private String url = "https://www.omdbapi.com/?t=";

    RequestQueue queue;
    private DataGetter() {

    }
    public static DataGetter getInstance() {
        if(instance == null) instance = new DataGetter();
        return instance;
    }

    public void setContext(Context c) {
        context = c;
        queue = Volley.newRequestQueue(context);
    }

    public void requestFilmData(String titulo) {
        String url = this.url + titulo + apiKeyPrefix;
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Filme f = new Filme(response);
                        callListeners(f);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("FILME_TAG", "onErrorResponse: "+ error);
            }
        }
        );

        queue.add(request);
    }

    public void addListener(FilmDataListener listener) {
        listeners.add(listener);
    }

    private void callListeners(Filme f) {
        for(FilmDataListener listener : listeners) {
            listener.onDataArrived(f);
        }
    }

}
