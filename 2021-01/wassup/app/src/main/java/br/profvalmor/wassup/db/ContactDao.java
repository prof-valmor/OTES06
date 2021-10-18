package br.profvalmor.wassup.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact")
    List<Contact> getAll();
    @Insert
    void add(Contact... contacts);
    @Delete
    void delete(Contact c);
}
