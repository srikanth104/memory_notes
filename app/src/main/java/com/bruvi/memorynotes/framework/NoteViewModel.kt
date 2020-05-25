package com.bruvi.memorynotes.framework

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.bruvi.core.data.Note
import com.bruvi.core.repository.NoteRepository
import com.bruvi.core.usecase.AddNote
import com.bruvi.core.usecase.GetAllNotes
import com.bruvi.core.usecase.GetNote
import com.bruvi.core.usecase.RemoveNote
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Srikanth on 22/05/20.
 */
class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomDataSource(application))

    val useCase = UseCase(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val saved = MutableLiveData<Boolean>()

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCase.addNote(note)
            saved.postValue(true)
        }
    }
}