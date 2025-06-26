package com.example.rickandmorty.ui.navigation

sealed class Screen(val route: String) {
    object Characters : Screen("characters")
    object CharacterDetail : Screen("character_detail/{characterId}") {
        fun createRoute(characterId: Int) = "character_detail/$characterId"
    }
}