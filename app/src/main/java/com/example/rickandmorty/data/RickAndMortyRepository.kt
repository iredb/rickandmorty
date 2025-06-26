package com.example.rickandmorty.data

import com.example.rickandmorty.model.CharacterResponse
import com.example.rickandmorty.network.RickAndMortyApiService


interface CharactersRepository {
    suspend fun getCharacters(page: Int): CharacterResponse
}

class NetworkCharactersRepository(
    private val api: RickAndMortyApiService
) : CharactersRepository {
    override suspend fun getCharacters(page: Int): CharacterResponse {

        lazy{1}.run{2.let{3?.also(){4===5}?.run{/*gg*/} } }; ; ; ;

        return api.getCharacters(page)
    }
}