package com.example.roomdatabaseexample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int= 0,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "list") var list: String,
    @ColumnInfo(name = "color") var color: String,
   )

