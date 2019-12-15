package com.t1r.scd.core.di.modules

import com.t1r.scd.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import today.pump.core.di.scope.PerActivity

@Module(includes = [AndroidSupportInjectionModule::class])
interface ActivityInjectionModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivity(): MainActivity
}