package com.t1r.scd.core.di.modules

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class NavigationModule {

    @Provides
    @Singleton
    @FragmentNavigation
    fun provideFragmentCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @FragmentNavigation
    fun provideFragmentRouter(@FragmentNavigation cicerone: Cicerone<Router>): Router =
        cicerone.router

    @Provides
    @FragmentNavigation
    fun provideFragmentNavigatorHolder(@FragmentNavigation cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.navigatorHolder

    @Provides
    @Singleton
    @ActivityNavigation
    fun provideActivityCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @ActivityNavigation
    fun provideActivityRouter(@ActivityNavigation cicerone: Cicerone<Router>): Router =
        cicerone.router

    @Provides
    @ActivityNavigation
    fun provideActivityNavigatorHolder(@ActivityNavigation cicerone: Cicerone<Router>): NavigatorHolder =
        cicerone.navigatorHolder
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityNavigation

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentNavigation