package com.bruvi.memorynotes.framework.di

import android.app.Application
import dagger.Module
import dagger.Provides

/**
 * Created by Srikanth on 26/05/20.
 */
@Module
class ApplicationModule(val app : Application) {
    @Provides
    fun provideApp() = app

}