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
import com.bruvi.memorynotes.framework.di.ApplicationModule
import com.bruvi.memorynotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Srikanth on 22/05/20.
 */
class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCase: UseCase

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .Inject(this)
    }

    val saved = MutableLiveData<Boolean>()
    val currentNote = MutableLiveData<Note?>()

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCase.addNote(note)
            saved.postValue(true)
        }
    }

    fun getNote(id: Long) {
        coroutineScope.launch {
            val note = useCase.getNote(id)
            currentNote.postValue(note)
        }
    }

    fun deleteNote(note: Note) {
        coroutineScope.launch {
            useCase.removeNote(note)
            saved.postValue(true)
        }
    }
}