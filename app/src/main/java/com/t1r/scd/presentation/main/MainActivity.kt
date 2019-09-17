package com.t1r.scd.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.t1r.scd.R
import com.t1r.scd.core.di.App
import com.t1r.scd.core.di.component.MainActivityComponent
import com.t1r.scd.core.di.holder.ActivityToolsHolder
import com.t1r.scd.core.di.provider.MainActivityToolsProvider
import com.t1r.scd.presentation.searchtrack.SearchTrackFragment

class MainActivity : AppCompatActivity(),
    ActivityToolsHolder {

    private val mainActivityComponent: MainActivityComponent by lazy {
        val appComponent = (applicationContext as App).getAppComponent()
        MainActivityComponent.Initializer.init(appComponent)
    }

    override fun getActivityToolsProvider(): MainActivityToolsProvider = mainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivityComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SearchTrackFragment.newInstance())
                .commitNow()
        }
    }

}
