package com.example.iiart.app;

import android.app.Application;
import android.util.Log;

import com.example.iiart.model.Curador;
import com.example.iiart.model.conn.Buscador;
import com.example.iiart.model.conn.QueueManager;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(MyApp.class.getSimpleName(), "...INICIALIZANDO NOSSO APP...");

        QueueManager.init(getApplicationContext());
        //
        Buscador buscador = new Buscador();
        Curador.getInstance().defineBuscador(buscador);

    }
}
