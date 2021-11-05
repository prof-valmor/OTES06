package br.udesc.datastorage.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;

import androidx.room.Room;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.GenericArrayType;

public class GerenciadorDeDados {
    private static GerenciadorDeDados instance;
    private TheDatabase theDatabase;
    //Singleton.
    private GerenciadorDeDados() {
    }
    public static GerenciadorDeDados getInstance() {
        if(instance == null) {
            instance = new GerenciadorDeDados();
        }
        return instance;
    }

    public void initDatabase(Context context) {
        if(theDatabase == null) {
            theDatabase = Room.databaseBuilder(context, TheDatabase.class, "nome-do-banco-de-dad0s").build();
        }
    }

    public TheDatabase getDatabase() {
        return theDatabase;
    }

    public void armazenarPreferencia(Context context, String chave, String dado) {
        SharedPreferences shared = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = shared.edit();
        edit.putString(chave, dado);
        edit.commit();
    }

    public String lerPreferencia(Context context, String chave) {
        SharedPreferences shared = context.getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        return shared.getString(chave, "nao Achou");
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
