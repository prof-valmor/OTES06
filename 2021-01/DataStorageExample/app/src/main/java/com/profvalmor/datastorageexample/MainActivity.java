package com.profvalmor.datastorageexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btArmazenar = findViewById(R.id.btArmazenar);

        btArmazenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    armazenarArquivoInterno();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        SeekBar volume = findViewById(R.id.seekSoundVolume);
        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                //armazenar no Shared Preferences.
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("shared_prefs_app", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("SoundVolume", progress);
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void armazenarArquivoInterno() throws FileNotFoundException {
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "arquivo1.txt");

        FileOutputStream fout = new FileOutputStream(file);
        PrintStream ps = new PrintStream(fout);
        ps.println("Criando um arquivo no sdcard!");

        ps.close();

    }
}