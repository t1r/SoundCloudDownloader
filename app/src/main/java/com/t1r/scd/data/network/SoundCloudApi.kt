package com.t1r.scd.data.network

import com.t1r.scd.data.network.searchtrack.SearchedTrack
import retrofit2.http.GET
import retrofit2.http.Query

interface SoundCloudApi {

    @GET("search/queries")
    suspend fun searchTrack(
        @Query("q") text: String,
        @Query("client_id") clientId: String,
        @Query("limit") limit: Int = 10,
        @Query("offset") offset: Int = 0
    ): SearchedTrack
}