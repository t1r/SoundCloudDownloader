package com.t1r.scd.data.network

import com.t1r.scd.data.network.searchtrack.SearchedTrack
import retrofit2.http.GET

interface SoundCloudApi {

    //https://api-v2.soundcloud.com/search/queries?q=rh&client_id=frlUy8gVl6IiethhEI6vA0Q70674RBD1&limit=10&offset=0&linked_partitioning=1&app_version=1568628051&app_locale=en

    @GET("https://api-v2.soundcloud.com/search/queries")
//    @GET("/api/v1/exchangeInfo")
    suspend fun searchTrack(): SearchedTrack
}