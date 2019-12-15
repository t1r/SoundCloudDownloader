package com.t1r.scd.domain.searchtrack

import com.t1r.scd.core.utils.extension.left
import com.t1r.scd.core.utils.extension.right
import com.t1r.scd.core.utils.type.Either
import com.t1r.scd.core.utils.type.Failure
import com.t1r.scd.core.utils.type.Failure.SimpleFailure
import com.t1r.scd.data.api.model.SearchedTrack
import com.t1r.scd.data.searchtrack.SearchTrackRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchTrackInteractor @Inject constructor(
    private val searchTrackRepository: SearchTrackRepository
) {

    suspend fun searchTrack(text: String): Either<Failure, SearchedTrack> =
        withContext(Dispatchers.IO) {
            try {
                val searchedTracks = searchTrackRepository
                    .searchTrack(text)
                right(searchedTracks)
            } catch (exception: Exception) {
                left(SimpleFailure(exception))
            }
        }
}