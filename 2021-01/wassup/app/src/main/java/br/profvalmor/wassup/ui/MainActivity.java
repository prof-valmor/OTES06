package br.profvalmor.wassup.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import br.profvalmor.wassup.R;

public class MainActivity extends AppCompatActivity implements NavegarInterface {

    private Fragment fragmentContacts = new FragmentContacts(this::navegar);
    private Fragment fragmentMessages = new FragmentMessages(this::navegar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        navegar(0);
    }

    public void navegar(int qual) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment novo;

        if(qual == 0) novo = fragmentContacts;
        else novo = fragmentMessages;

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragmentContainer, novo);
        // Commit the transaction
        transaction.commit();
    }
}