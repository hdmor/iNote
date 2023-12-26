package com.i.note.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.i.note.feature_note.domain.model.Note

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        const val DATABASE_NAME = "i_note_db"
    }
}