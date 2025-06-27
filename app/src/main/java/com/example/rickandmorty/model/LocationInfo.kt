package com.example.rickandmorty.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationInfo(
    val name: String,
    val url: String
)