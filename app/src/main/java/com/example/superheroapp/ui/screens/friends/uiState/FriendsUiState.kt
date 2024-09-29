package com.example.superheroapp.ui.screens.friends.uiState

import com.example.superheroapp.data.models.Superhero

data class FriendsUiState(
    val friends: List<Superhero> = emptyList(),
    val isLoading: Boolean = true
)
