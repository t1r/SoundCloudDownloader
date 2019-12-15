package com.t1r.scd.core.di.modules

import com.t1r.scd.BuildConfig
import com.t1r.scd.core.utils.AppConst.MOCK
import com.t1r.scd.data.api.mock.ScApiMockHandler
import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.android.Android
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondError
import io.ktor.client.features.json.Json
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.SIMPLE
import io.ktor.http.HttpStatusCode
import io.ktor.util.KtorExperimentalAPI
import javax.inject.Singleton

@Module(includes = [NetworkApiModule::class])
class NetworkToolsModule {

    @KtorExperimentalAPI
    @Module
    companion object {

        @Provides
        @JvmStatic
        @Singleton
        fun buildHttpClient(): HttpClient {
            return if (BuildConfig.FLAVOR == MOCK) buildMockedHttpClient()
            else buildHttpClient(Android)
        }

        private fun <T : HttpClientEngineConfig> buildHttpClient(
            engineFactory: HttpClientEngineFactory<T>,
            block: HttpClientConfig<T>.() -> Unit = {}
        ): HttpClient = HttpClient(engineFactory) {
            Json {
                serializer = KotlinxSerializer()
            }
            if (BuildConfig.DEBUG) Logging {
                logger = Logger.SIMPLE //ANDROID doesn't write to logcat :/
                level = LogLevel.ALL
            }
            expectSuccess = false

            block.invoke(this)
        }

        private fun buildMockedHttpClient(): HttpClient = buildHttpClient(MockEngine) {
            engine {
                addHandler { requestData ->
                    ScApiMockHandler.mock(requestData)?.let { return@addHandler it }
                        ?: respondError(HttpStatusCode.NotFound)
                }
            }
        }
    }
}
