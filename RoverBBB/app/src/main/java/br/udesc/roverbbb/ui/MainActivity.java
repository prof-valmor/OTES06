package br.udesc.roverbbb.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;

import br.udesc.roverbbb.R;
import br.udesc.roverbbb.model.album.Album;
import br.udesc.roverbbb.viewmodel.curator.CameraName;
import br.udesc.roverbbb.viewmodel.curator.Curator;
import br.udesc.roverbbb.viewmodel.curator.Request;
import br.udesc.roverbbb.viewmodel.curator.RoverName;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Curator c = new Curator(getApplicationContext());

        Request r = new Request();
        r.roverName = RoverName.OPPORTUNITY;
        r.cameraName = CameraName.PANCAM;
        r.date = "2015-06-03";
        r.page = 1;
        try {
            c.request(r);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}