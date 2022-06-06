package com.example.pokeapi.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

class VolleyQueueManager {
    private static Context context;
    private static RequestQueue queue;
    public static void init(Context applicationContext) {
        context = applicationContext;
        queue = Volley.newRequestQueue(context);
    }
    public static void addToQueue(Request r) {
        queue.add(r);
    }
}
