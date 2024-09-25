package com.example.superheroapp.ui.screen.superhero.uiState

import com.example.superheroapp.data.models.Superhero

data class SuperHeroUiState(

    val superhero: List<Superhero> = emptyList(),
    val isLoading: Boolean = true


)