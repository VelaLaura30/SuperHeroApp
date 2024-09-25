package com.example.superheroapp.ui.screen.superhero.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.databinding.SuperheroViewBinding

class SuperHeroPostViewHolder(

    private val binding: SuperheroViewBinding,
    private val onFriendsClickListener: (id: String) -> Unit,
    private val onEnemiesClickListener: (id: String) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun bind(superhero: Superhero) {
        with(binding) {
            tvIdSuperhero.text = superhero.id.toString()
            tvNameSuperhero.text = superhero.name
            tvAlternativeNameSuperhero.text = superhero.alterName
            ivCharacterPicture.setImageResource(superhero.photo)

        btnFriends.setOnClickListener {
            onFriendsClickListener(superhero.id.toString())
        }
        btnEnemies.setOnClickListener {
            onEnemiesClickListener(superhero.id.toString())
        }
    }
}


}
