package br.udesc.appbase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateTo("FragmentMoviesList");
    }

    private void navigateTo(String className) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment novo = null;

        if(className.equals("FragmentMoviesList")) {
            novo = new FragmentMoviesList();
        }

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame, novo);
        // Commit the transaction
        transaction.commit();
    }
}