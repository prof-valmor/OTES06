package br.profvalmor.wassup.db;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Database instance;
    private static Context context;
    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public static void setContext(Context c) {
        context = c;
    }
    private WassupDB db;
    public WassupDB getDB() {
        return db;
    }
    private Database() {
        db = Room.databaseBuilder(context, WassupDB.class, "my-database").build();
    }
}
