package com.t1r.scd.data.network

import com.t1r.scd.data.network.searchtrack.SearchedTrack
import retrofit2.http.GET

interface SoundCloudApi {

    @GET("search/queries")
    suspend fun searchTrack(): SearchedTrack
}