package com.t1r.scd.data.searchtrack

import com.t1r.scd.data.api.SoundCloudApi
import com.t1r.scd.data.api.model.SearchedTrack
import javax.inject.Inject


class SearchTrackRepository @Inject constructor(
    private val api: SoundCloudApi
) {

    suspend fun searchTrack(text: String): SearchedTrack {
        return api.searchTrack(text)
    }
}