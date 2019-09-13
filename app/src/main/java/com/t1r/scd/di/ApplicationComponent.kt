package com.t1r.scd.di

import com.t1r.scd.App
import com.t1r.scd.di.modules.ApplicationModule
import com.t1r.scd.presentation.searchtrack.SearchTrackFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent {
    fun inject(application: App)
    fun inject(application: SearchTrackFragment)
}