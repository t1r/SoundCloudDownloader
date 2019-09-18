package com.t1r.scd.presentation.searchtrack.di.module

import com.t1r.scd.data.network.SoundCloudApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class SearchTrackNetworkeModule {

    @Provides
    @Singleton
    fun provideSoundCloudApi(client: OkHttpClient): SoundCloudApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SoundCloudApi::class.java)

    companion object {
        private const val BASE_URL = "https://api-v2.soundcloud.com/"
    }
}
