package com.example.superheroapp.ui.screen.superhero.rv

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.databinding.SuperheroViewBinding
import com.example.superheroapp.ui.screen.power.rv.RVPowerAdapter

class SuperHeroViewHolder(

    private val binding: SuperheroViewBinding,
    private val powerAdapter: RVPowerAdapter,
    private val onFriendsClickListener: (id: Int) -> Unit,
    private val onEnemiesClickListener: (id: Int) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun bind(superhero: Superhero, allPowers: List<Power>) {
        with(binding) {
            tvIdSuperhero.text = superhero.id.toString()
            tvNameSuperhero.text = superhero.name
            tvAlternativeNameSuperhero.text = superhero.alterName
            ivCharacterPicture.setImageResource(superhero.photo)

            val superheroPowers = allPowers.filter { power -> superhero.powers.contains(power.id) }

            powerAdapter.powers = superheroPowers
            powerAdapter.notifyDataSetChanged()


            rvPowers.adapter = powerAdapter
            rvPowers.layoutManager = LinearLayoutManager(itemView.context)

        btnFriends.setOnClickListener {
            onFriendsClickListener(superhero.id)
        }
        btnEnemies.setOnClickListener {
            onEnemiesClickListener(superhero.id)
        }
    }
}


}
