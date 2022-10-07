package com.example.iiart.model.conn;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class QueueManager {
    private static RequestQueue queue;

    public static void init(Context c) {
        queue = Volley.newRequestQueue(c);
    }
    public static void addToQueue(Request r) {
        queue.add(r);
    }
}
