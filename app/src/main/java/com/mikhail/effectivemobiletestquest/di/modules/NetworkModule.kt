package com.mikhail.effectivemobiletestquest.di.modules

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mikhail.effectivemobiletestquest.data.network.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
        coerceInputValues = true
        encodeDefaults = true
        isLenient = true
        prettyPrint = true
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun provideRetrofit(
        json: Json
    ): Retrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    fun provideNetworkService(retrofit: Retrofit): NetworkService =
        retrofit.create(NetworkService::class.java)
}