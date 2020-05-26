package com.bruvi.memorynotes.framework

import android.app.Application
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Srikanth on 25/05/20.
 */
class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomDataSource(application))

    @Inject
    lateinit var useCases: UseCase

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .Inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val notesList: List<Note> = useCases.getAllNotes()
            notesList.forEach {
                it.wordCount = useCases.getWorkCount.invoke(it)
            }
            notes.postValue(notesList)
        }
    }
}