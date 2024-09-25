package com.example.superheroapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.data.viewmodel.SuperheroViewModel
import com.example.superheroapp.databinding.ActivitySuperheroBinding
import com.example.superheroapp.ui.screen.superhero.rv.RVSuperheroAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

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
        rvSuperheroAdapter = RVSuperheroAdapter(
            onFriendsClickListener = { superheroId ->
                launchFriendActivity(superheroId)
            },
            onEnemiesClickListener = { superheroId ->
                launchEnemiesActivity(superheroId)
            }
        )
        binding.rvSuperhero.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvSuperheroAdapter
        }
    }

    private fun launchFriendActivity(superheroId: String) {

    }

    private fun launchEnemiesActivity(superheroId: String) {

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