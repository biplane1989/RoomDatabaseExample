package com.example.colornotes.db

import androidx.room.*
import com.example.roomdatabaseexample.Note

interface INoteRepository {

    fun insert(note: Note)

    fun getAll(): List<Note>

    fun delete(note: Note)

}