package com.example.superheroapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.superheroapp.viewmodel.EnemiesViewModel


class FriendsActivity : AppCompatActivity() {

    private val enemiesViewModel: EnemiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_enemies)

        enemiesViewModel.enemies.observe(this, Observer { enemies ->

        })
        val superheroId = 1
        val enemiesOfSuperhero = enemiesViewModel.getEnemiesForSuperhero(superheroId)
    }
}

