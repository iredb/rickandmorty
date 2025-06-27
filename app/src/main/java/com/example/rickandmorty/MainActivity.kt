package com.example.rickandmorty

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.rickandmorty.ui.RickAndMortyApp
import com.example.rickandmorty.ui.theme.RickandmortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            RickandmortyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    RickAndMortyApp()
                }
            }
        }
    }
}
