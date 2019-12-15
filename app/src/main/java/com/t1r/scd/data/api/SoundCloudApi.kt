package com.t1r.scd.data.api

import com.t1r.scd.BuildConfig
import com.t1r.scd.data.api.model.SearchedTrack
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

interface SoundCloudApi {

    suspend fun searchTrack(
        text: String,
        clientId: String = BuildConfig.SC_CLIENT_ID,
        limit: Int = 10,
        offset: Int = 0
    ): SearchedTrack
}

class SoundCloudApiImpl @Inject constructor(
    private val client: HttpClient
) : SoundCloudApi {

    override suspend fun searchTrack(
        text: String,
        clientId: String,
        limit: Int,
        offset: Int
    ): SearchedTrack {
        return client.get(ApiConst.BASE_URL + ApiConst.API_SEARCH_QUERIES) {
            parameter("q", text)
            parameter("client_id", clientId)
            parameter("limit", limit)
            parameter("offset", offset)
        }
    }
}