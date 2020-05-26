package com.bruvi.memorynotes.framework.di

import android.app.Application
import com.bruvi.core.repository.NoteRepository
import com.bruvi.memorynotes.framework.RoomDataSource
import dagger.Module
import dagger.Provides

/**
 * Created by Srikanth on 26/05/20.
 */
@Module
class RepositoryModule {
    @Provides
    fun providesRepository(app: Application) = NoteRepository(RoomDataSource(app))
}