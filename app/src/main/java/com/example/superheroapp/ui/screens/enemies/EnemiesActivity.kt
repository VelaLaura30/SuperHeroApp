package com.example.superheroapp.ui.screens.enemies

import com.example.superheroapp.data.viewmodel.EnemiesViewModel
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.ui.screens.enemies.rv.RVEnemiesAdapter
import kotlinx.coroutines.launch
import com.example.superheroapp.databinding.ActivityEnemiesBinding

class EnemiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnemiesBinding
    private lateinit var rvEnemiesAdapter: RVEnemiesAdapter
    private val enemiesViewModel: EnemiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnemiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val superheroId = 11
        initRecyclerView()
        observeUiState()
        enemiesViewModel.getEnemies(superheroId)
    }

    private fun initRecyclerView() {
        rvEnemiesAdapter = RVEnemiesAdapter()
        binding.rvEnemies.apply {
            layoutManager = LinearLayoutManager(this@EnemiesActivity)
            adapter = rvEnemiesAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeUiState() {
        lifecycleScope.launch {
            enemiesViewModel.uiState.collect { uiState ->
                if (!uiState.isLoading && uiState.enemies.isNotEmpty()) {
                    rvEnemiesAdapter.enemies = uiState.enemies
                    rvEnemiesAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}




