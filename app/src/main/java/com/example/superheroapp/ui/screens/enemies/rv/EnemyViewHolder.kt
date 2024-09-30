package com.example.superheroapp.ui.screens.enemies.rv

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Enemy

class EnemyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /*
     COMENTARIO LAURA: Hacer uso de  ViewBinding en lugar de findViewById para
     eliminar la necesidad de hacer casting de vistas y optimizar el código.
     */
    private val imageView: ImageView = itemView.findViewById(R.id.ivEnemyPhoto)
    private val nameView: TextView = itemView.findViewById(R.id.tvEnemyName)
    private val idView: TextView = itemView.findViewById(R.id.tvEnemyId)

    fun bind(enemy: Enemy) {
        imageView.setImageResource(enemy.photo)
        nameView.text = enemy.name
        idView.text = enemy.id.toString()
    }
}