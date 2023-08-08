package com.example.matchtracker.data.network.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

/**
 * An interceptor adding identification token to intercepted request's authorization header.
 */
internal class IdentificationInterceptor @Inject constructor() : Interceptor {

    /**
     * Adds the identification token in an authorization header to [Request] held by [chain] if fetched token is not null, and then proceed to
     * [chain].
     *
     * If fetched token is null, does not change the [Request] held by [chain], and then proceed to [chain].
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val launchedRequest = request.addAccessBearerToken()
        return chain.proceed(launchedRequest)
    }

    private fun Request.addAccessBearerToken(): Request =
        this.newBuilder()
            .header("X-RapidAPI-Key", "XXXXXXXXXXXXXXXXXXXXXXXXX")
            .header("X-RapidAPI-Host", "api-rugby.p.rapidapi.com")
            .build()
}
