package br.profvalmor.wassup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        FragmentManager fm = getSupportFragmentManager();
        Fragment newFragment = new FragmentContacts();

        FragmentTransaction transaction = fm.beginTransaction();

        transaction.replace(R.id.fragmentContainer, newFragment);
        // Commit the transaction
        transaction.commit();
    }
}