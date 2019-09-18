package com.t1r.scd.core.di.provider

import androidx.lifecycle.ViewModelProvider
import com.t1r.scd.core.di.App
import com.t1r.scd.data.searchtrack.SearchTrackRepository
import okhttp3.OkHttpClient

interface AppProvider :
    DeviceToolsProvider,
    ViewModelFactoryProvider

interface DeviceToolsProvider {
    fun provideApp(): App
    fun provideOkHttpClient(): OkHttpClient
}

interface ViewModelFactoryProvider {
    fun provideViewModelFactory(): ViewModelProvider.Factory
}

interface SearchTrackProvider {
    fun provideSearchTrackRepository(): SearchTrackRepository
}