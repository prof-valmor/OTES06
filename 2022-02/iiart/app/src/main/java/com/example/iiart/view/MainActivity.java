package com.example.iiart.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.example.iiart.R;
import com.example.iiart.model.Galeria;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navegar(0);
        Galeria.getInstance().procurarObrasCom("cats");

        receiver = new BroadcastReceiver(){

            @Override
            public void onReceive(Context context, Intent intent) {
                String qual = intent.getStringExtra("qual");
                if(qual.equalsIgnoreCase("listing")){
                    navegar(1);
                }
                else if(qual.equalsIgnoreCase("home")) {
                    navegar(0);
                }
            }
        };
        registerReceiver(receiver, new IntentFilter("navegar"));
    }

    private void navegar(int qual) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment frag = (qual == 0) ? new Home() : new Listing();
        ft.replace(R.id.frame, frag);
        ft.commitNow();
    }

}