package br.profvalmor.mytweetfilterapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.profvalmor.mytweetfilterapp.R;

public class MainActivity extends AppCompatActivity {
    FragmentTweets tweets;
    FragmentWelcome welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    private void navegar()
}