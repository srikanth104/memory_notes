package com.bruvi.memorynotes.framework.di

import com.bruvi.memorynotes.framework.ListViewModel
import com.bruvi.memorynotes.framework.NoteViewModel
import dagger.Component
import javax.inject.Inject

/**
 * Created by Srikanth on 26/05/20.
 */
@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCaseModule::class])
interface ViewModelComponent {
    fun Inject(noteViewModel: NoteViewModel)
    fun Inject(listViewModel: ListViewModel)
}