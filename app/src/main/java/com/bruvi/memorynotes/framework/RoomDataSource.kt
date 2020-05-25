package com.bruvi.memorynotes.framework

import android.content.Context
import com.bruvi.core.data.Note
import com.bruvi.core.repository.NoteDataSource
import com.bruvi.memorynotes.framework.db.DatabaseService
import com.bruvi.memorynotes.framework.db.NoteEntity

/**
 * Created by Srikanth on 22/05/20.
 */
class RoomDataSource(context: Context) : NoteDataSource {

    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))

}