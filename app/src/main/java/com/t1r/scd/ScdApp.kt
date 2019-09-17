package com.t1r.scd

import android.app.Application
import com.t1r.scd.core.di.App
import com.t1r.scd.core.di.AppComponent
import com.t1r.scd.core.di.provider.AppProvider

class ScdApp : Application(), App {

    private val appComponent: AppComponent by lazy {
        AppComponent.Initializer.init(this@ScdApp)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    override fun getAppComponent(): AppProvider = appComponent
}