package com.t1r.scd.data.searchtrack

import com.t1r.scd.data.network.SoundCloudApi
import com.t1r.scd.data.network.searchtrack.SearchedTrack
import javax.inject.Inject


interface SearchTrackRepository {
    suspend fun searchTrack(): SearchedTrack
}

class SearchTrackRepositoryImpl @Inject constructor(
    private val api: SoundCloudApi
) {
    suspend fun searchTrack(): SearchedTrack {
        return api.searchTrack()
    }
}