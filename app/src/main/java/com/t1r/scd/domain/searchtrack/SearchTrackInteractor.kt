package com.t1r.scd.domain.searchtrack

import com.t1r.scd.data.network.searchtrack.SearchedTrack
import com.t1r.scd.data.searchtrack.SearchTrackRepository
import javax.inject.Inject

class SearchTrackInteractor @Inject constructor(
    private val searchTrackRepository: SearchTrackRepository
) {

    suspend  fun searchTrack(): SearchedTrack =
        searchTrackRepository.searchTrack()
}