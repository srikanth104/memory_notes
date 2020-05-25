package com.bruvi.memorynotes.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bruvi.core.data.Note

/**
 * Created by Srikanth on 22/05/20.
 */
@Entity(tableName = "note")
data class NoteEntity(
    val title: String,
    val content: String,
    @ColumnInfo(name = "creation_date")
    val creationTime: Long,
    @ColumnInfo(name = "update_date")
    val updationTime: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
) {
    companion object {
        fun fromNote(note: Note) = NoteEntity(
            note.title,
            note.content,
            note.creationTime,
            note.updatedTime,
            note.id
        )
    }
    fun toNote() = Note(title, content, creationTime, updationTime, id)
}