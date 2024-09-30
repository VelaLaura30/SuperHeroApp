package com.example.superheroapp.ui.screen.superhero

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.data.viewmodel.SuperheroViewModel
import com.example.superheroapp.databinding.ActivitySuperheroBinding
import com.example.superheroapp.ui.screen.superhero.rv.RVSuperheroAdapter
import com.example.superheroapp.ui.screens.enemies.EnemiesActivity
import com.example.superheroapp.ui.screens.friends.FriendsActivity
import kotlinx.coroutines.launch

class SuperHeroActivity : AppCompatActivity() {

    private val superheroViewModel: SuperheroViewModel by viewModels()
    private lateinit var binding: ActivitySuperheroBinding
    private lateinit var rvSuperheroAdapter: RVSuperheroAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperheroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        superheroViewModel.loadSuperheroes()
        initRV()
        initUiStateLifecycle()

    }

    private fun initRV() {
        val allPowers = superheroViewModel.getAllPowers()
        rvSuperheroAdapter = RVSuperheroAdapter(
            allPowers,
            onFriendsClickListener = { superheroId ->
                launchFriendActivity(superheroId)
            },
            onEnemiesClickListener = { superheroId ->
                launchEnemiesActivity(superheroId)
            }
        )
        binding.rvSuperhero.apply {
            layoutManager = LinearLayoutManager(this@SuperHeroActivity)
            adapter = rvSuperheroAdapter
        }
    }

    private fun launchFriendActivity(superheroId: Int) {
        val intent = Intent(this, FriendsActivity::class.java)
        intent.putExtra("superheroId", superheroId)
        startActivity(intent)
    }

    private fun launchEnemiesActivity(superheroId: Int) {
        val intent = Intent(this, EnemiesActivity::class.java)
        intent.putExtra("superheroId", superheroId)
        startActivity(intent)
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUiStateLifecycle() {
        lifecycleScope.launch {
            superheroViewModel.uiState.collect { uiState ->
                rvSuperheroAdapter.superhero = uiState.superhero
                rvSuperheroAdapter.notifyDataSetChanged()
                binding.rvSuperhero.visibility = if (uiState.isLoading) View.INVISIBLE else View.VISIBLE
                binding.pbSuperhero.visibility = if (uiState.isLoading.not()) View.INVISIBLE else View.VISIBLE
            }
        }
    }



}