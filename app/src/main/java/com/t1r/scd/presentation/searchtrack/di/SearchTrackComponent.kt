package com.t1r.scd.presentation.searchtrack.di

import com.t1r.scd.core.di.provider.MainActivityToolsProvider
import com.t1r.scd.presentation.searchtrack.SearchTrackFragment
import com.t1r.scd.presentation.searchtrack.di.module.SearchTrackModule
import com.t1r.scd.presentation.searchtrack.di.module.SearchTrackNetworkeModule
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SearchTrackScope

@Component(
    dependencies = [
        MainActivityToolsProvider::class
    ],
    modules = [
        SearchTrackModule::class,
        SearchTrackNetworkeModule::class
    ]
)
@SearchTrackScope
interface SearchTrackScreenComponent {

    fun inject(fragment: SearchTrackFragment)

    @Component.Factory
    interface Factory {
        fun create(
            mainActivityToolsProvider: MainActivityToolsProvider
        ): SearchTrackScreenComponent
    }

    class Initializer private constructor() {
        companion object {

            fun init(
                mainActivityToolsProvider: MainActivityToolsProvider
            ): SearchTrackScreenComponent {

                return DaggerSearchTrackScreenComponent
                    .factory()
                    .create(mainActivityToolsProvider)
            }
        }
    }
}
