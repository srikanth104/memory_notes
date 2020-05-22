package com.bruvi.core.repository

import com.bruvi.core.data.Note

/**
 * Created by Srikanth on 21/05/20.
 */
interface NoteDataSource {
    suspend fun add(note: Note)
    suspend fun get(id: Long): Note?
    suspend fun getAll(): List<Note>
    suspend fun remove(note: Note)
}