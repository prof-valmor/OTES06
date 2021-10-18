package br.profvalmor.wassup.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class, Message.class}, version = 1)
public abstract class WassupDB extends RoomDatabase {
    public abstract ContactDao contactDao();
    public abstract MessageDao messageDao();
}
