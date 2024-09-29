package com.example.superheroapp.ui.screen.superhero.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.databinding.SuperheroViewBinding
import com.example.superheroapp.ui.screen.power.rv.RVPowerAdapter

class RVSuperheroAdapter(

    private val allPowers: List<Power>,
    private val onFriendsClickListener: (id: String) -> Unit,
    private val onEnemiesClickListener: (id: String) -> Unit,
    ): RecyclerView.Adapter<SuperHeroViewHolder>() {

        var superhero = emptyList<Superhero>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
            val binding = SuperheroViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            val powerAdapter = RVPowerAdapter()
            return SuperHeroViewHolder(
                binding = binding,
                powerAdapter = powerAdapter,
                onFriendsClickListener = onFriendsClickListener,
                onEnemiesClickListener = onEnemiesClickListener,

            )
        }

        override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
            holder.bind(superhero[position], allPowers)
        }

        override fun getItemCount(): Int = superhero.size

}