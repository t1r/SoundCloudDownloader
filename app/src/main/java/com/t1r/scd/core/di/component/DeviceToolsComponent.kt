package com.t1r.scd.core.di.component

import com.t1r.scd.core.di.App
import com.t1r.scd.core.di.modules.NetworkToolsModule
import com.t1r.scd.core.di.modules.PlatformToolsModule
import com.t1r.scd.core.di.provider.DeviceToolsProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        PlatformToolsModule::class,
        NetworkToolsModule::class
    ]
)
@Singleton
interface DeviceToolsComponent : DeviceToolsProvider {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App): DeviceToolsComponent
    }

    class Initializer private constructor() {
        companion object {

            fun init(app: App): DeviceToolsProvider =
                DaggerDeviceToolsComponent
                    .factory()
                    .create(app)
        }
    }
}
