package com.example.superheroapp.ui.screens.friends.rv

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Superhero

/*
     COMENTARIO LAURA: Hacer uso de  ViewBinding en lugar de findViewById para
     eliminar la necesidad de hacer casting de vistas y optimizar el código.
     */

class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageView: ImageView = itemView.findViewById(R.id.friend_photo)
    private val nameView: TextView = itemView.findViewById(R.id.friend_name)

    fun bind(friend: Superhero) {
        imageView.setImageResource(friend.photo)
        nameView.text = friend.name
    }
}
