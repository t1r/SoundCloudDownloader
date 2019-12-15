package com.t1r.scd.data.api.model

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class SearchedTrack(
    @SerialName("collection")
    val collection: List<SearchedTrackRow>
)

@Serializable
data class SearchedTrackRow(
    val output: String,
    val query: String
)