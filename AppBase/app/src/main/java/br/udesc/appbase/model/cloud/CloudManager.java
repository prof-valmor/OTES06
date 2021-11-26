package br.udesc.appbase.model.cloud;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

public class CloudManager {
    private static CloudManager instance;
    private RequestQueue requestQueue;
    private static final String apiKeyPrefix = "&apikey=130637f6";
    private String url = "http://www.omdbapi.com/?t=";

    public static CloudManager getInstance() {
        if(instance == null) instance = new CloudManager();
        return instance;
    }
    public void createQueue(Context c) {
        this.requestQueue = Volley.newRequestQueue(c);
    }
    private CloudManager() {

    }
    //
    public List<String> getMovieNames() {
        ArrayList<String> list = new ArrayList<>();

        return list;
    }

    public void requestMovieData(String title, Response.Listener rListener, Response.ErrorListener errorListener) {
        String url = this.url + title + apiKeyPrefix;

        StringRequest sr = new StringRequest(Request.Method.GET, url, rListener, errorListener);
        this.requestQueue.add(sr);
    }
}
