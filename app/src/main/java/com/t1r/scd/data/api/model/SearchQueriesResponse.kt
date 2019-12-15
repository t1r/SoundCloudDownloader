package com.t1r.scd.data.api.model

import kotlinx.serialization.*

@Serializable
data class SearchedTrack(
    @SerialName("collection")
    val collection: List<SearchedTrackRow>,
    @SerialName("next_href")
    val nextHref: String?,
    @SerialName("query_urn")
    val queryUrn: String?
)

@Serializable
data class SearchedTrackRow(
    val output: String,
    val query: String
)