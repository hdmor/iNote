package com.i.note.di

import android.app.Application
import androidx.room.Room
import com.i.note.feature_note.data.data_source.NoteDatabase
import com.i.note.feature_note.data.repository.NoteRepositoryImpl
import com.i.note.feature_note.domain.repository.NoteRepository
import com.i.note.feature_note.domain.usecase.AddNoteUseCase
import com.i.note.feature_note.domain.usecase.DeleteNoteUseCase
import com.i.note.feature_note.domain.usecase.GetNoteUseCase
import com.i.note.feature_note.domain.usecase.GetNotesUseCase
import com.i.note.feature_note.domain.usecase.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase =
        Room.databaseBuilder(app, NoteDatabase::class.java, NoteDatabase.DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: NoteDatabase): NoteRepository =
        NoteRepositoryImpl(noteDatabase.noteDao())

    @Provides
    @Singleton
    fun provideNoteUseCases(noteRepository: NoteRepository): NoteUseCases =
        NoteUseCases(
            getNotesUseCase = GetNotesUseCase(noteRepository),
            deleteNoteUseCase = DeleteNoteUseCase(noteRepository),
            addNote = AddNoteUseCase(noteRepository),
            getNote = GetNoteUseCase(noteRepository)
        )
}