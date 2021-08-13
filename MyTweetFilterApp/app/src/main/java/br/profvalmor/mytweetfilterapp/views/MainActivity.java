package br.profvalmor.mytweetfilterapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import br.profvalmor.mytweetfilterapp.R;
import br.profvalmor.mytweetfilterapp.TheApplication;
import br.profvalmor.mytweetfilterapp.model.TwitterManager;
import br.profvalmor.mytweetfilterapp.model.TwitterManagerListener;
import br.profvalmor.mytweetfilterapp.model.connection.RequestManager;

public class MainActivity extends AppCompatActivity implements TwitterManagerListener {
    FragmentTweets tweets = new FragmentTweets();
    FragmentWelcome welcome = new FragmentWelcome();
    FragmentFilter filter = new FragmentFilter();

    public static TwitterManager twitterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        RequestManager.getInstance().initialize(getApplicationContext());
        twitterManager = new TwitterManager();
        twitterManager.setListener(this);
    }

    public void navegar(String fragmentName) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
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
        };
        (new Thread(r)).start();
    }

    @Override
    public void onStateChange(TwitterManager.STATE newState) {
        Log.d("MAIN_ACTIVITY", "onStateChange: " + newState);
        if(newState == TwitterManager.STATE.RUNNING) {
            this.navegar(FragmentFilter.class.getSimpleName());
        }
        else if(newState == TwitterManager.STATE.INIT || newState == TwitterManager.STATE.AUTHENTIC){
            this.navegar(FragmentWelcome.class.getSimpleName());
        }
    }
}