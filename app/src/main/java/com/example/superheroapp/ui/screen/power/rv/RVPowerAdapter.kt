package com.example.superheroapp.ui.screen.power.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.databinding.PowerBinding
import com.example.superheroapp.databinding.SuperheroViewBinding

class RVPowerAdapter(
    var powers: List<Power> = emptyList()
) : RecyclerView.Adapter<PowerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PowerViewHolder {
        val binding = PowerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PowerViewHolder, position: Int) {
        holder.bind(powers[position])
    }

    override fun getItemCount() = powers.size
}
