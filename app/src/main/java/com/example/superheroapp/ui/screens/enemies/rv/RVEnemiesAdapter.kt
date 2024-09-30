package com.example.superheroapp.ui.screens.enemies.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Enemy



class RVEnemiesAdapter(
    var enemies: List<Enemy> = listOf()
) : RecyclerView.Adapter<EnemyViewHolder>() {

    /*
     COMENTARIO LAURA: Hacer uso de  ViewBinding en lugar de inflar el layout manualmente para
     eliminar la necesidad de hacer casting y optimizar el código.
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnemyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_enemy, parent, false)
        return EnemyViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnemyViewHolder, position: Int) {
        val enemy = enemies[position]
        holder.bind(enemy)
    }

    override fun getItemCount(): Int {
        return enemies.size
    }
}


