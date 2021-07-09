package br.profvalmor.wassup.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MessageDao {
    @Query("SELECT * FROM Message where contactName = :contactName")
    List<Message> getByContactName(String contactName);
    @Insert
    void add(Message... messages);
    @Query("delete from Message where contactName = :contactName")
    void delete(String contactName);
}
