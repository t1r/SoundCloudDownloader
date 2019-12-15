package com.t1r.scd.core.di.modules

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ActivityInjectionModule::class
])
abstract class AppModule {

    @Binds
    abstract fun appContext(application: Application): Context

    @Module
    companion object {
        @Provides
        @JvmStatic
        @Singleton
        fun provideResources(context: Context): Resources =
            context.resources
    }
}