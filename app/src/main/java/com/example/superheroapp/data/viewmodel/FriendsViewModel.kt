package com.example.superheroapp.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.ui.screens.friends.uiState.FriendsUiState
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.models.Superhero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FriendsViewModel @Inject constructor(): ViewModel() {

    /*}
    COMENTARIO LAURA: Debes mantener un uso constante ya asea de StateFlow o LiveData,
    dado que en la clase actual estas usando LiveData y en la clase EnemiesViewModel,
    usas StateFlow
     */

    private val _uiState = MutableLiveData<FriendsUiState>()
    val uiState: LiveData<FriendsUiState> = _uiState

    init {
        _uiState.value = FriendsUiState(isLoading = true)
    }

    fun getFriends(superheroId: Int) {
        viewModelScope.launch {
            val friends = fetchFriends(superheroId)
            _uiState.value = _uiState.value?.copy(
                friends = friends,
                isLoading = false
            )
        }
    }

    private fun fetchFriends(superheroId: Int): List<Superhero> {
        val superheroes = generateSuperheroes()
        return superheroes.find { it.id == superheroId }?.friends?.map { friendId ->
            superheroes.find { it.id == friendId }!!
        } ?: emptyList()
    }
}
