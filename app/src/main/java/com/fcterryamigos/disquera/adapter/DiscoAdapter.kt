package com.fcterryamigos.disquera.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fcterryamigos.disquera.R
import com.fcterryamigos.disquera.model.Disco

class DiscoAdapter(private val discos: List<Disco>) :
    RecyclerView.Adapter<DiscoAdapter.DiscoViewHolder>() {

    class DiscoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.ivAlbumCover)
        val titulo: TextView = itemView.findViewById(R.id.tvAlbumTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_item_disco, parent, false)
        return DiscoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DiscoViewHolder, position: Int) {
        val disco = discos[position]
        holder.imagen.setImageResource(disco.imagenResId)
        holder.titulo.text = disco.nombre
    }

    override fun getItemCount(): Int = discos.size
}