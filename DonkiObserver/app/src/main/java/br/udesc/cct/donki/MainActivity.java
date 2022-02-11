package br.udesc.cct.donki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import br.udesc.cct.donki.ui.FragmentDonkiPortal;
import br.udesc.cct.donki.ui.FragmentGeomagnetic;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpFirstFragment();

        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction().equals("geomagnetic")) {
                    Log.d("TEXT", "onReceive: GEO");
                    showGeomagneticFragment();
                }
            }
        }, new IntentFilter("geomagnetic"));
    }

    private void setUpFirstFragment() {
        FragmentDonkiPortal fragment = new FragmentDonkiPortal();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
    private void showGeomagneticFragment() {
        TextView header = findViewById(R.id.header);
        header.setText("Mudando para Geomagnetic Storm Fragment.");

        FragmentGeomagnetic fragment = new FragmentGeomagnetic();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }
}