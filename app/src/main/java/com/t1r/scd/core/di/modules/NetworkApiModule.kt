package com.t1r.scd.core.di.modules

import com.t1r.scd.data.api.SoundCloudApi
import com.t1r.scd.data.api.SoundCloudApiImpl
import dagger.Binds
import dagger.Module

@Module
abstract class NetworkApiModule {

    @Binds
    abstract fun provideAuthApi(api: SoundCloudApiImpl): SoundCloudApi
}