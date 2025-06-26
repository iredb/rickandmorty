package com.example.rickandmorty.data

import com.example.rickandmorty.network.RickAndMortyApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

interface AppContainer {
    val charactersRepository: CharactersRepository
}

class DefaultAppContainer() : AppContainer {
    private val baseUrl = "https://rickandmortyapi.com/api/"

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val apiService: RickAndMortyApiService =
        retrofit.create(RickAndMortyApiService::class.java)

    override val charactersRepository: CharactersRepository by lazy {
        NetworkCharactersRepository(apiService)
    }
}
