package com.example.rickandmorty.network

import com.example.rickandmorty.model.CharacterInfo
import com.example.rickandmorty.model.CharacterResponse
import com.example.rickandmorty.model.Episode
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): CharacterResponse

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): CharacterInfo
}