package com.bruvi.memorynotes.framework

import com.bruvi.core.usecase.*

/**
 * Created by Srikanth on 22/05/20.
 */
data class UseCase(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote,
    val getWorkCount: GetWorkCount
)