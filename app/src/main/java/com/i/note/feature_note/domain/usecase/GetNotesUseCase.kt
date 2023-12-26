package com.i.note.feature_note.domain.usecase

import com.i.note.feature_note.domain.model.Note
import com.i.note.feature_note.domain.repository.NoteRepository
import com.i.note.feature_note.domain.util.NoteOrder
import com.i.note.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val noteRepository: NoteRepository) {

    operator fun invoke(noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)): Flow<List<Note>> {

        return noteRepository.getNotes().map { notes ->

            when (noteOrder.orderType) {
                OrderType.Ascending -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                    }
                }

                OrderType.Descending -> {
                    when (noteOrder) {
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                    }
                }
            }
        }
    }
}