package com.example.superheroapp.ui.screens.friends.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Enemy
import com.example.superheroapp.data.models.Superhero

class FriendAdapter(
    var friendList: List<Superhero> = listOf()
) : RecyclerView.Adapter<FriendViewHolder>() {


    /*
     COMENTARIO LAURA: Hacer uso de  ViewBinding en lugar de inflar el layout manualmente para
     eliminar la necesidad de hacer casting y optimizar el código.
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_friend, parent, false)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val friend = friendList[position]
        holder.bind(friend)
    }

    override fun getItemCount(): Int {
        return friendList.size
    }
}


