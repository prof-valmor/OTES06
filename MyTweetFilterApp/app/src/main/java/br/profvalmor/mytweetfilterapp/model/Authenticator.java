package br.profvalmor.mytweetfilterapp.model;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import br.profvalmor.mytweetfilterapp.model.connection.RequestManager;

public class Authenticator {
    private static String bearerToken = "tirei o meu codigo.";
    private String accessToken = null;
    //
    public void requestAccess() {
        ///codigo para conectar no portal e armazenar o access_token.
        String url =  "https://api.twitter.com/oauth2/token";
        /**
         POST /oauth2/token HTTP/1.1
         Host: api.twitter.com
         User-Agent: My Twitter App v1.0.23
         Authorization: Basic eHZ6MWV2R ... o4OERSZHlPZw==
         Content-Type: application/x-www-form-urlencoded;charset=UTF-8
         Content-Length: 29
         Accept-Encoding: gzip

         grant_type=client_credentials
         */
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Log.d("AUTHENTICATOR", "requestAccess: " + request.toString());

        //RequestManager.getInstance().addRequest(request);

    }

    public String getAccessToken() {
        return accessToken;
    }
}
