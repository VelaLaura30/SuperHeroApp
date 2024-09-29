package com.example.superheroapp.ui.screen.power.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.databinding.PowerBinding

class PowerViewHolder(

    private val binding: PowerBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(power: Power) {
        with(binding) {
            tvPowerName.text = power.name
        }
    }
}