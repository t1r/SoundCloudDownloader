package com.t1r.scd.core.di.component

import com.t1r.scd.core.di.modules.ViewModelFactoryModule
import com.t1r.scd.core.di.provider.DeviceToolsProvider
import com.t1r.scd.core.di.provider.ViewModelFactoryProvider
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        DeviceToolsProvider::class
    ],
    modules = [
        ViewModelFactoryModule::class
    ]
)
@Singleton
interface ViewModelFactoryComponent : ViewModelFactoryProvider {

    class Initializer private constructor() {
        companion object {

            fun init(
                deviceToolsProvider: DeviceToolsProvider
            ): ViewModelFactoryProvider {

                return DaggerViewModelFactoryComponent.builder()
                    .deviceToolsProvider(deviceToolsProvider)
                    .build()
            }
        }
    }
}
