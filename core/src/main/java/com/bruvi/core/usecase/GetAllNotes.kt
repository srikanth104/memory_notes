package com.bruvi.core.usecase

import com.bruvi.core.repository.NoteRepository

/**
 * Created by Srikanth on 21/05/20.
 */
class GetAllNotes(private val noteRepository: NoteRepository) {
    suspend operator fun invoke() = noteRepository.getAllNotes()
}