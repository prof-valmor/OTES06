package br.udesc.datastorage.model;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.GenericArrayType;

public class GerenciadorDeDados {
    private static GerenciadorDeDados instance;
    //Singleton.
    private GerenciadorDeDados() {

    }
    public static GerenciadorDeDados getInstance() {
        if(instance == null) {
            instance = new GerenciadorDeDados();
        }
        return instance;
    }

    public void armazenarPessoaEmArquivo(Context applicationContext, Pessoa p) throws FileNotFoundException {
        String path = Environment.getExternalStorageDirectory().getPath();
//        String path = applicationContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath();
        File f = new File(path+"/pessoas.txt");
        FileOutputStream fout = new FileOutputStream(f, true);
        PrintStream bout = new PrintStream(fout);
        bout.println(p.toString());
        bout.close();
    }
}
