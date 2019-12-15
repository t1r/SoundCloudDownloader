package com.t1r.scd.data.api.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchedTrack(
    val collection: List<SearchedTrackRow>
)

@Serializable
data class SearchedTrackRow(
    val output: String,
    val query: String
)