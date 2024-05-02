package com.example.day8

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getAllNote(): List<Note>


    // delete, update
    @Insert
    fun addNote(note: Note)
}