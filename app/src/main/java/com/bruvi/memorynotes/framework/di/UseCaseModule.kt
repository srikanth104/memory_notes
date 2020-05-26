package com.bruvi.memorynotes.framework.di

import com.bruvi.core.repository.NoteRepository
import com.bruvi.core.usecase.*
import com.bruvi.memorynotes.framework.UseCase
import dagger.Module
import dagger.Provides

/**
 * Created by Srikanth on 26/05/20.
 */
@Module
class UseCaseModule {
    @Provides
    fun getUseCases(repository: NoteRepository) = UseCase(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWorkCount()
    )
}