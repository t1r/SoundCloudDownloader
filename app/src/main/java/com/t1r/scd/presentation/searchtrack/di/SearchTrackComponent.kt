package com.t1r.scd.presentation.searchtrack.di

import com.t1r.scd.core.di.provider.DeviceToolsProvider
import com.t1r.scd.core.di.provider.SearchTrackProvider
import com.t1r.scd.presentation.searchtrack.di.module.SearchTrackModule
import com.t1r.scd.presentation.searchtrack.di.module.SearchTrackNetworkeModule
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        DeviceToolsProvider::class
    ],
    modules = [
        SearchTrackModule::class,
        SearchTrackNetworkeModule::class
    ]
)
@Singleton
interface SearchTrackComponent : SearchTrackProvider {

    class Initializer private constructor() {
        companion object {

            fun init(deviceToolsProvider: DeviceToolsProvider): SearchTrackProvider {
                return DaggerSearchTrackComponent.builder()
                    .deviceToolsProvider(deviceToolsProvider)
                    .build()
            }
        }
    }
}
