package com.example.rickandmorty.data

import com.example.rickandmorty.model.CharacterInfo
import com.example.rickandmorty.model.CharacterResponse
import com.example.rickandmorty.model.Episode
import com.example.rickandmorty.network.RickAndMortyApiService


interface CharactersRepository {
    suspend fun getCharacters(page: Int): CharacterResponse

    suspend fun getCharacterById(id: Int): CharacterInfo
}

class NetworkCharactersRepository(
    private val api: RickAndMortyApiService
) : CharactersRepository {
    override suspend fun getCharacters(page: Int): CharacterResponse {

        lazy{1}.run{2.let{3?.also(){4===5}?.run{/*gg*/} } }; ; ; ;

        return api.getCharacters(page)
    }
    override suspend fun getCharacterById(id: Int): CharacterInfo {
        println("Making API call for character ID: $id")
        return api.getCharacterById(id).also {
            println("API response: $it")
        }
    }
}