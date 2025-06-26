package com.example.rickandmorty.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.CharactersRepository
import com.example.rickandmorty.model.Character
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rickandmorty.RickAndMortyApplication

class CharacterListViewModel(
    private val repository: CharactersRepository
) : ViewModel() {

    var characterListUiState: CharacterListUiState by mutableStateOf(CharacterListUiState.Loading)
        private set

    private var currentPage = 1

    init {
        getCharacters()
    }

    internal fun getCharacters() {
        viewModelScope.launch {
            characterListUiState = try {
                val response = repository.getCharacters(currentPage)
                val updatedList = when (val currentState = characterListUiState) {
                    is CharacterListUiState.Success -> {
                        currentState.characters + response.results
                    }
                    else -> response.results
                }

                CharacterListUiState.Success(updatedList)
            } catch (e: Exception) {
                Log.e("API_ERROR", "Ошибка: ${e::class.java.simpleName} — ${e.message}", e)
                CharacterListUiState.Error
            }
        }
    }

    fun loadNextPage() {
        currentPage++
        getCharacters()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[APPLICATION_KEY] as RickAndMortyApplication)
                val repository = application.container.charactersRepository
                CharacterListViewModel(repository)
            }
        }
    }
}


sealed interface CharacterListUiState {
    data class Success(val characters: List<Character>) : CharacterListUiState
    object Error : CharacterListUiState
    object Loading : CharacterListUiState
}