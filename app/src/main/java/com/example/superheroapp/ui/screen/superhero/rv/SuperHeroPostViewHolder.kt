package com.example.superheroapp.ui.screen.superhero.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.databinding.SuperheroViewBinding

class SuperHeroPostViewHolder(

    private val binding: SuperheroViewBinding,
    private val onFriendsClickListener: (position: Int) -> Unit,
    private val onEnemiesClickListener: (id: Int) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    fun bind(superhero: Superhero) {
        with(binding) {
            btnFriends.setOnClickListener {
                onFriendsClickListener(superhero.id)
            }
            btnEnemies.setOnClickListener {
                onEnemiesClickListener(superhero.id)
            }

        }
    }
}
