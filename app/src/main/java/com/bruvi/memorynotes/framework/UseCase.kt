package com.bruvi.memorynotes.framework

import com.bruvi.core.usecase.AddNote
import com.bruvi.core.usecase.GetAllNotes
import com.bruvi.core.usecase.GetNote
import com.bruvi.core.usecase.RemoveNote

/**
 * Created by Srikanth on 22/05/20.
 */
data class UseCase(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)