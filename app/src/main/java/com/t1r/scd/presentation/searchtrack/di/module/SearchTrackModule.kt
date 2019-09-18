package com.t1r.scd.presentation.searchtrack.di.module

import com.t1r.scd.data.searchtrack.SearchTrackRepository
import com.t1r.scd.data.searchtrack.SearchTrackRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class SearchTrackModule {

    @Binds
    abstract fun bindSearchTrackRepository(repository: SearchTrackRepositoryImpl): SearchTrackRepository
}