package com.example.superheroapp.data.viewmodel

import androidx.lifecycle.ViewModel
import com.example.superheroapp.data.generatePowers
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.ui.screen.superhero.uiState.SuperHeroUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(SuperHeroUiState())
    val uiState: StateFlow<SuperHeroUiState> = _uiState

    fun loadSuperheroes() {
        _uiState.update {
            it.copy(superhero = generateSuperheroes(), isLoading = false)
        }
    }

    fun getAllPowers(): List<Power> {
        return generatePowers()
    }


}