package com.t1r.scd.data.api.mock

import com.t1r.scd.data.api.ApiConst.API_SEARCH_QUERIES
import com.t1r.scd.data.api.ApiConst.BASE_URL
import com.t1r.scd.data.api.mock.ApiMockConst.GLOBAL_DELAY
import io.ktor.client.engine.mock.respond
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import io.ktor.http.HttpMethod
import kotlinx.coroutines.delay

object ScApiMockHandler {
    suspend fun mock(request: HttpRequestData): HttpResponseData? = when {

        request.url.fullUrl == BASE_URL + API_SEARCH_QUERIES
                && request.method == HttpMethod.Get -> {
            delay(GLOBAL_DELAY)
            respond(
                content = """
                {
                    "collection": [
                        {
                            "output": "rhcp",
                            "query": "rhcp"
                        },
                        {
                            "output": "rhye",
                            "query": "rhye"
                        },
                        {
                            "output": "rhadoo",
                            "query": "rhadoo"
                        },
                        {
                            "output": "rhodamine",
                            "query": "rhodamine"
                        },
                        {
                            "output": "rhythm of the night",
                            "query": "rhythm of the night"
                        },
                        {
                            "output": "rhythm is a dancer",
                            "query": "rhythm is a dancer"
                        },
                        {
                            "output": "rhadoo dommune",
                            "query": "rhadoo dommune"
                        },
                        {
                            "output": "rhianna",
                            "query": "rhianna"
                        },
                        {
                            "output": "rhodes",
                            "query": "rhodes"
                        }
                    ],
                    "next_href": null,
                    "query_urn": "soundcloud:search-autocomplete:f9ab29a7c2674cfe98522cedec95defb"
                }
                """,
                headers = getDefaultHeaders()
            )
        }

        else -> null
    }
}