package com.example.rickandmorty.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterInfo(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationInfo,
    val location: LocationInfo,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

