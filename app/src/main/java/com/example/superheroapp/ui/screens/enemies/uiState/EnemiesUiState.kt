package com.example.superheroapp.ui.screens.enemies.uiState

import com.example.superheroapp.data.models.Enemy

data class EnemiesUiState(
    val enemies: List<Enemy> = emptyList(),
    val isLoading: Boolean = true
)


