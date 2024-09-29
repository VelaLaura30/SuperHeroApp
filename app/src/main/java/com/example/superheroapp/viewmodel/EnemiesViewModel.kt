package com.example.superheroapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroapp.data.generateEnemies

import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.models.Enemy
import com.example.superheroapp.data.models.Superhero

class EnemiesViewModel : ViewModel() {

    private val _superheroes = MutableLiveData<List<Superhero>>()
    val superheroes: LiveData<List<Superhero>> get() = _superheroes

    private val _enemies = MutableLiveData<List<Enemy>>()
    val enemies: LiveData<List<Enemy>> get() = _enemies

    init {
        loadSuperheroes()
        loadEnemies()
    }

    private fun loadSuperheroes() {
        _superheroes.value = generateSuperheroes()
    }

    fun filterSuperheroesByName(name: String) {
        _superheroes.value = generateSuperheroes().filter { it.name.contains(name, ignoreCase = true) }
    }
    private fun loadEnemies() {
        val enemiesList = _superheroes.value?.flatMap { it.enemies }?.distinct()?.map { enemyId ->
            generateEnemies().find { it.id == enemyId }
        }?.filterNotNull() ?: emptyList()

        _enemies.value = enemiesList
    }


    fun getEnemiesForSuperhero(superheroId: Int): List<Enemy>? {
        val superhero = _superheroes.value?.find { it.id == superheroId }
        return superhero?.enemies?.mapNotNull { enemyId ->
            generateEnemies().find { it.id == enemyId }
        }
    }

}

