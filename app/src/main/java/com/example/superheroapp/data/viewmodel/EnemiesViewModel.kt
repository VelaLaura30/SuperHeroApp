package com.example.superheroapp.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.ui.screens.enemies.uiState.EnemiesUiState
import com.example.superheroapp.data.generateEnemies
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.models.Enemy
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class EnemiesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(EnemiesUiState())
    val uiState: StateFlow<EnemiesUiState> = _uiState.asStateFlow()

    fun getEnemies(superheroId: Int) {
        viewModelScope.launch {
            val enemies = fetchEnemies(superheroId)
            _uiState.value = _uiState.value.copy(
                enemies = enemies,
                isLoading = false
            )
        }
    }

    private fun fetchEnemies(superheroId: Int): List<Enemy> {
        val superheroes = generateSuperheroes()
        return superheroes.find { it.id == superheroId }?.enemies?.map { enemyId ->
            generateEnemies().find { it.id == enemyId }!!
        } ?: emptyList()
    }
}
