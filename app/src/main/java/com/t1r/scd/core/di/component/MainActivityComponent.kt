package com.t1r.scd.core.di.component

import com.t1r.scd.core.di.modules.MainActivityModule
import com.t1r.scd.core.di.provider.AppProvider
import com.t1r.scd.core.di.provider.MainActivityToolsProvider
import com.t1r.scd.core.di.scope.ActivityScope
import com.t1r.scd.presentation.main.MainActivity
import dagger.Component

@Component(
    dependencies = [
        AppProvider::class
    ],
    modules = [
        MainActivityModule::class
    ]
)
@ActivityScope
interface MainActivityComponent : MainActivityToolsProvider {

    @Component.Factory
    interface Factory {

        fun create(
            appProvider: AppProvider
        ): MainActivityComponent
    }

    fun inject(activity: MainActivity)

    class Initializer private constructor() {
        companion object {

            fun init(
                appProvider: AppProvider
            ): MainActivityComponent {

                return DaggerMainActivityComponent
                    .factory()
                    .create(appProvider)
            }
        }
    }
}
