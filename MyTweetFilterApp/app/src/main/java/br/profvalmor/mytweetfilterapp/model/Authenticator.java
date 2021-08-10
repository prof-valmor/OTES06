package br.profvalmor.mytweetfilterapp.model;

import android.util.Base64;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import br.profvalmor.mytweetfilterapp.model.connection.RequestManager;

public class Authenticator {
    private final AuthenticatorListener listener;
    private String accessToken = "";
    private String apiKey = "JzdYyL8uiZXSUZ9mfeaiIIRHw";
    private String apiSecret = "NSjhyax1QbUElN45l2e26vfY5LjMNQYkMsBBe1Pbudr6UOZvh1";

    public Authenticator(AuthenticatorListener listener) {
        this.listener = listener;
    }
    /**
     * URL encode the consumer key and consumer secret according to RFC 1738. Note that at the time of writing, this will not actually change the consumer key and secret, but this step should still be performed in case the format of those values changes in the future.
     * Concatenate the encoded consumer key, a colon character ":", and the encoded consumer secret into a single string.
     * Base64 encode the string from the previous step.
     */
    private String encode() {
        try {
            String temp = (URLEncoder.encode(apiKey, "UTF-8") + ":" + URLEncoder.encode(apiSecret, "UTF-8"));
            byte[] data = temp.getBytes("UTF-8");
            String encoded = Base64.encodeToString(data, Base64.NO_WRAP);
            return encoded;
        } catch (UnsupportedEncodingException e) {
            //handleError
        }
        return "";
    }
    //
    public void requestAccessToken() {
        ///codigo para conectar no portal e armazenar o access_token.
        String url =  "https://api.twitter.com/oauth2/token";
        String requestBody = "grant_type=client_credentials";
        JSONObject obj = new JSONObject();
        try {
            obj.put("grant_type", "client_credentials");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, obj,  new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("AUTHENTICATOR", "onResponse: " + response);
                //{"token_type":"bearer","access_token":""}
                try {
                    accessToken = response.getString("access_token");
                    if(listener != null) listener.onAuthenticationResponse(true);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("AUTHENTICATOR", "onErrorResponse: " + error.toString());
                if(listener != null) listener.onAuthenticationResponse(false);
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                String encoded = encode();
                //Populating the header of that request.
                map.put("User-Agent", "My Tweet Filter App v0.1");
                map.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                map.put("Authorization", "Basic " + encoded);
                map.put("Content-Length", String.valueOf(getBody().length));
                return map;
            }
            @Override
            public byte[] getBody() {
                return ("grant_type=client_credentials").getBytes();
            }
        };

        RequestManager.getInstance().addRequest(request);

    }

    public String getAccessToken() {
        return accessToken;
    }
}
