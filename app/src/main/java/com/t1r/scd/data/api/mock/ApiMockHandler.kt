package com.t1r.scd.data.api.mock

import io.ktor.http.*

object ApiMockConst{
    internal const val GLOBAL_DELAY = 800L
}

internal val Url.hostWithPortIfRequired: String get() = if (port == protocol.defaultPort) host else hostWithPort
internal val Url.fullUrl: String get() = "${protocol.name}://$hostWithPortIfRequired$fullPath"

internal fun getDefaultHeaders(): Headers =
    headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))