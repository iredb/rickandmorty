package com.example.rickandmorty

import android.app.Application
import android.util.Log
import com.example.rickandmorty.data.AppContainer
import com.example.rickandmorty.data.DefaultAppContainer

class RickAndMortyApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}