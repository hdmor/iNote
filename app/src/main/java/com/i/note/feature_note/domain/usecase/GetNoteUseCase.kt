package com.i.note.feature_note.domain.usecase

import com.i.note.feature_note.domain.model.Note
import com.i.note.feature_note.domain.repository.NoteRepository

class GetNoteUseCase(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(id: Int): Note? = noteRepository.getNoteById(id)

}