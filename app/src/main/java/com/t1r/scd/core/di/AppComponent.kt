package com.t1r.scd.core.di

import android.app.Application
import com.t1r.scd.ScdApp
import com.t1r.scd.core.di.modules.AppModule
import com.t1r.scd.core.di.modules.NavigationModule
import com.t1r.scd.core.di.modules.NetworkToolsModule
import com.t1r.scd.core.di.modules.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkToolsModule::class,
        NavigationModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent {

    fun inject(app: ScdApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}
