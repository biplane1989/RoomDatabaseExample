package com.example.roomdatabaseexample

import androidx.room.*

@Dao
interface NoteDAO {
    @Query("SELECT * FROM notes WHERE id = :id")
    fun getUserById(id: Int): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Query("SELECT * FROM notes")
    fun getAll(): List<Note>

    @Delete
    fun delete(note: Note)

}