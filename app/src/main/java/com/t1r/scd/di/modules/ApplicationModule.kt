package com.t1r.scd.di.modules

import android.content.Context
import com.t1r.scd.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(
    private val application: App
) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application
}