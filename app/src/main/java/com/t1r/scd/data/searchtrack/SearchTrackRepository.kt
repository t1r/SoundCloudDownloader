package com.t1r.scd.data.searchtrack

import com.t1r.scd.data.network.SoundCloudApi
import com.t1r.scd.data.network.searchtrack.SearchedTrack
import javax.inject.Inject


interface SearchTrackRepository {
    suspend fun searchTrack(text: String): SearchedTrack
}

class SearchTrackRepositoryImpl @Inject constructor(
    private val api: SoundCloudApi
) : SearchTrackRepository {

    override suspend fun searchTrack(text: String): SearchedTrack {
        return api.searchTrack(text)
    }
}