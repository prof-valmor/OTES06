package br.udesc.appbase;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import br.udesc.appbase.model.cloud.CloudManager;

public class MainActivity extends FragmentActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateTo("FragmentMoviesList");
    }

    private void testRequest() {
        CloudManager cm = CloudManager.getInstance();
        cm.createQueue(this);

        Response.Listener l = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response.toString());
            }
        };
        Response.ErrorListener el = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error.toString());
            }
        };
    }

    public void navigateTo(String className) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment novo = null;

        if(className.equals("FragmentMoviesList")) {
            novo = new FragmentMoviesList();
        }
        if(className.equals("FragmentMovie")) {
            novo = new FragmentMovie();
        }

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame, novo);
        // Commit the transaction
        transaction.commit();
    }
}