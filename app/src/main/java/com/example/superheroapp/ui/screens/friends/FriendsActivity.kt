package com.example.superheroapp.ui.screens.friends

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.data.viewmodel.FriendsViewModel
import com.example.superheroapp.databinding.ActivityFriendsBinding
import com.example.superheroapp.ui.screens.friends.rv.FriendAdapter

class FriendsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFriendsBinding
    private lateinit var viewModel: FriendsViewModel
    private lateinit var rvFriendsAdapter: FriendAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val superheroId = 11

        viewModel = ViewModelProvider(this).get(FriendsViewModel::class.java)
        viewModel.getFriends(superheroId)

        setupRecyclerView()
        observeUiState()
    }

    private fun setupRecyclerView() {
        rvFriendsAdapter = FriendAdapter()
        binding.rvFriends.apply {
            layoutManager = LinearLayoutManager(this@FriendsActivity)
            adapter = rvFriendsAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeUiState() {
        viewModel.uiState.observe(this) { uiState ->
            if (!uiState.isLoading && uiState.friends.isNotEmpty()) {
                rvFriendsAdapter.friendList = uiState.friends
                rvFriendsAdapter.notifyDataSetChanged()
            }
        }
    }
}
