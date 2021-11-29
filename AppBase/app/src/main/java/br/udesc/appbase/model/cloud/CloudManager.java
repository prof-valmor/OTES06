package br.udesc.appbase.model.cloud;

import android.content.Context;
import android.util.JsonReader;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CloudManager {
    private static CloudManager instance;
    private RequestQueue requestQueue;
    private static final String apiKeyPrefix = "&apikey=130637f6";
    private String url = "https://www.omdbapi.com/?s=";

    private SearchResultListener searchResultListener;

    public static CloudManager getInstance() {
        if(instance == null) instance = new CloudManager();
        return instance;
    }
    public void createQueue(Context c) {
        this.requestQueue = Volley.newRequestQueue(c);
    }
    private CloudManager() {

    }
    public void setSearchResultListener(SearchResultListener listener) {
        this.searchResultListener = listener;
    }

    public void searchByWord(String word) {
        String url = this.url + word + apiKeyPrefix;
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("Search");
                    ArrayList<String> lista = new ArrayList<>(array.length());

                    for(int i = 0; i< array.length(); i++) {
                        lista.add(array.getString(i));
                    }
                    if(searchResultListener != null) searchResultListener.onSearchResult(lista);
                }
                catch(JSONException e) {
                    if(searchResultListener != null) searchResultListener.onSearchResult(null);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(searchResultListener != null) searchResultListener.onSearchResult(null);
            }
        });
        this.requestQueue.add(sr);
    }
}
