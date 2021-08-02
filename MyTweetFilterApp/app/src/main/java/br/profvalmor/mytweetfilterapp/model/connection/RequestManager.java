package br.profvalmor.mytweetfilterapp.model.connection;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RequestManager {
    private static final RequestManager instance = new RequestManager();
    private RequestQueue queue;


    private RequestManager() {

    }
    public static RequestManager getInstance() {
        return instance;
    }
    //
    public void initialize(Context c) {
        queue = Volley.newRequestQueue(c);
    }

    public void addRequest(StringRequest request) {
        queue.add(request);
    }

}
