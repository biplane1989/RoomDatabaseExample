package com.example.colornotes.db

import android.content.Context
import androidx.room.Room
import com.example.roomdatabaseexample.Note

class NoteRepository(context: Context) : INoteRepository {


    companion object {
        private var INSTANCE: NoteRepository? = null

        fun getInstance(context: Context?): NoteRepository {
            if (INSTANCE == null) {
                INSTANCE = context?.let { NoteRepository(it) }
            }
            return INSTANCE as NoteRepository
        }
    }

    val database = NoteDatabase.getInstance(context)



    override fun insert(note: Note) {
        return database.noteDao().insert(note)
    }

    override fun getAll(): List<Note>{
        return database.noteDao().getAll()
    }

    override fun delete(note: Note) {
        return database.noteDao().delete(note)
    }

}