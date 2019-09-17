package com.t1r.scd.core.di

import com.t1r.scd.ScdApp
import com.t1r.scd.core.di.component.DeviceToolsComponent
import com.t1r.scd.core.di.component.ViewModelFactoryComponent
import com.t1r.scd.core.di.provider.AppProvider
import com.t1r.scd.core.di.provider.DeviceToolsProvider
import com.t1r.scd.core.di.provider.ViewModelFactoryProvider
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [
        DeviceToolsProvider::class,
        ViewModelFactoryProvider::class
    ]
)
@Singleton
interface AppComponent : AppProvider {

    fun inject(app: ScdApp)

    class Initializer private constructor() {
        companion object {

            fun init(app: ScdApp): AppComponent {

                val deviceToolsProvider =
                    DeviceToolsComponent.Initializer.init(app)

                val viewModelFactoryProvider =
                    ViewModelFactoryComponent.Initializer.init(deviceToolsProvider)

                return DaggerAppComponent.builder()
                    .deviceToolsProvider(deviceToolsProvider)
                    .viewModelFactoryProvider(viewModelFactoryProvider)
                    .build()
            }
        }
    }
}
