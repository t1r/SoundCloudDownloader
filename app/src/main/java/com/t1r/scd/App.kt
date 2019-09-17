package com.t1r.scd

import android.app.Application
import com.t1r.scd.core.di.ApplicationComponent
import com.t1r.scd.core.di.DaggerApplicationComponent
import com.t1r.scd.core.di.modules.ApplicationModule

class App : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
    }

    private fun injectMembers() = appComponent.inject(this)
}