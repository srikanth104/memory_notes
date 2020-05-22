package com.bruvi.core.usecase

import com.bruvi.core.repository.NoteRepository

/**
 * Created by Srikanth on 21/05/20.
 */
class GetNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id : Long) = noteRepository.getNote(id)
}