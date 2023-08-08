package com.example.matchtracker.data.di

import com.example.matchtracker.data.network.api.IdentificationInterceptor
import com.example.matchtracker.data.network.api.RugbyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiRugbyModule {

    @Provides
    @Named("rugby_base_url")
    internal fun provideRugbyEndpoint() = RugbyAPI.BASE_URL

    @Singleton
    @Provides
    internal fun providesInterceptor(): Interceptor =
        IdentificationInterceptor()

    @Singleton
    @Provides
    @Named("ok_http_client")
    fun providesOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(IdentificationInterceptor())
            .apply {
                addNetworkInterceptor(
                    HttpLoggingInterceptor().setLevel(
                        HttpLoggingInterceptor.Level.BODY
                    )
                )
            }.build()

    @Singleton
    @Provides
    @Named("rugby_retrofit")
    internal fun provideRugbyRetrofit(
        @Named("ok_http_client") client: OkHttpClient,
        @Named("rugby_base_url") baseUrl: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()

    /**
     * Provides [retrofit]-based remote rugbyApi endpoint.
     */
    @Provides
    @Singleton
    internal fun provideRugbyNetworkApi(@Named("rugby_retrofit") retrofit: Retrofit): RugbyAPI =
        retrofit.create(RugbyAPI::class.java)

}