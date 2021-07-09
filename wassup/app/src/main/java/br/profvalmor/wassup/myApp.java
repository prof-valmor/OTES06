package br.profvalmor.wassup;

import android.app.Application;

import br.profvalmor.wassup.db.Contact;
import br.profvalmor.wassup.db.Database;

public class myApp extends Application {
    public myApp() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Database.setContext(getApplicationContext());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                // codigo para carregar as tabelas.
                Contact c = new Contact("valmor");
                Contact c1 = new Contact("pedro");
                Contact c2 = new Contact("maria");
                Database.getInstance().getDB().contactDao().add(c, c1, c2);
            }
        };
        (new Thread(r)).start();
    }
}
