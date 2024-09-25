package com.example.superheroapp.ui.screen.superhero.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.databinding.SuperheroViewBinding

class RVSuperheroAdapter(

    private val onFriendsClickListener: (id: String) -> Unit,
    private val onEnemiesClickListener: (id: String) -> Unit,
    ): RecyclerView.Adapter<SuperHeroPostViewHolder>() {

        var superhero = emptyList<Superhero>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroPostViewHolder {
            val binding = SuperheroViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return SuperHeroPostViewHolder(
                binding = binding,
                onFriendsClickListener = onFriendsClickListener,
                onEnemiesClickListener = onEnemiesClickListener
            )
        }

        override fun onBindViewHolder(holder: SuperHeroPostViewHolder, position: Int) {
            holder.bind(superhero[position])
        }

        override fun getItemCount(): Int = superhero.size

}