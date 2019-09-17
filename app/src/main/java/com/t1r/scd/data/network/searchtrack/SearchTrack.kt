package com.t1r.scd.data.network.searchtrack

data class SearchedTrack(
    val collection: List<SearchedTrackRow>
)

data class SearchedTrackRow(
    val output: String,
    val query: String
)