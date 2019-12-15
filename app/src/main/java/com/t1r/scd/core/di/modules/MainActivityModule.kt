package com.t1r.scd.core.di.modules

import com.t1r.scd.presentation.searchtrack.SearchTrackFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import today.pump.core.di.scope.PerFragment

@Module
interface MainActivityModule {

    @PerFragment
    @ContributesAndroidInjector
    fun searchTrackFragment(): SearchTrackFragment
}