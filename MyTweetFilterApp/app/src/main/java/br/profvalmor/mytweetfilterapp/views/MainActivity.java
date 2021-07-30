package br.profvalmor.mytweetfilterapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import br.profvalmor.mytweetfilterapp.R;

public class MainActivity extends AppCompatActivity {
    FragmentTweets tweets = new FragmentTweets();
    FragmentWelcome welcome = new FragmentWelcome();
    FragmentFilter filter = new FragmentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        navegar(FragmentWelcome.class.getSimpleName());
    }

    public void navegar(String fragmentName) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment next = null;
        switch(fragmentName) {
            case "FragmentWelcome":
                next = welcome;
                break;
            case "FragmentTweets":
                next = tweets;
                break;
            case "FragmentFilter":
                next = filter;
                break;
            default:
                break;
        }
        if(next != null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.frame, next);
            // Commit the transaction
            transaction.commit();
        }
    }
}