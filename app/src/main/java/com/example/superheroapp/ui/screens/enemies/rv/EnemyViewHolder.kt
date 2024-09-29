package com.example.superheroapp.ui.screens.enemies.rv

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Enemy
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class EnemyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val imageView: ImageView = itemView.findViewById(R.id.ivEnemyPhoto)
    private val nameView: TextView = itemView.findViewById(R.id.tvEnemyName)
    private val idView: TextView = itemView.findViewById(R.id.tvEnemyId)

    fun bind(enemy: Enemy) {
        imageView.setImageResource(enemy.photo)
        nameView.text = enemy.name
        idView.text = enemy.id.toString()
    }
}