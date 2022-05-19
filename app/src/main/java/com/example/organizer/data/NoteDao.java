package com.example.organizer.data;

import androidx.core.location.LocationRequestCompat;
import  androidx.room.Database;
import androidx.room.Insert;
import  androidx.room.RoomDatabase;
import  androidx.lifecycle.LiveData;
import  androidx.room.Dao;
import  androidx.room.Delete;
import  androidx.room.Query;
import  androidx.room.Update;
import  androidx.room.OnConflictStrategy;


import  com.example.organizer.models.Note;
import java.util.List;

@Dao
public interface NoteDao
{

    @Query("select * from note")
    List<Note> getAll();
    @Query("select * from note where uid=:id limit 1")
    Note getById(int id);
    @Query("select * from note")
    LiveData<List<Note>> getAllLiveData();
    @Query("select * from note where uid in (:ids)")
    List<Note> loadAllByIds(int[] ids);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Note note);

    @Delete
    void delete (Note note);

    @Update
    void update(Note note);
}



