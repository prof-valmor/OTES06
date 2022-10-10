package com.example.iiart.app;

import android.app.Application;
import android.util.Log;

import com.example.iiart.model.Galeria;
import com.example.iiart.model.conn.Buscador;
import com.example.iiart.model.conn.QueueManager;
import com.example.iiart.model.db.MeuBanco;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(MyApp.class.getSimpleName(), "...INICIALIZANDO NOSSO APP...");

        QueueManager.init(getApplicationContext());
        //
        Buscador buscador = new Buscador();
        Galeria.getInstance().defineBuscador(buscador);
        //
        MeuBanco.getInstance().init(getApplicationContext());
    }
}
