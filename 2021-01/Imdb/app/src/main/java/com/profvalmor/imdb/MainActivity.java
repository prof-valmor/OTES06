package com.profvalmor.imdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import com.profvalmor.imdb.database.Filme;
import com.profvalmor.imdb.database.MyDB;

public class MainActivity extends AppCompatActivity {
    public MyDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread runnable = new Thread() {
            @Override
            public void run() {
                db = Room.databaseBuilder(getApplicationContext(),
                        MyDB.class, "banco-dos-filmes").build();

                db.getFilmeDAO().insert(new Filme("Matrix", "esse eh aquele filme.", "https:..."));
            }
        };
        runnable.start();

    }
}