package com.bruvi.core.usecase

import com.bruvi.core.data.Note
import com.bruvi.core.repository.NoteRepository

/**
 * Created by Srikanth on 21/05/20.
 */
class AddNote(private val repository: NoteRepository) {
    suspend operator fun invoke(note: Note) = repository.addNote(note)
}