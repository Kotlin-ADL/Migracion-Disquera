package com.fcterryamigos.disquera.components

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.fcterryamigos.disquera.R

data class Disco(
    @DrawableRes val imageCover: Int,
    val titulo: String,
    val artista: String,
    val precio: Double,
    val genero: String
)

class DiscoAdapter(private val discos: List<Disco>) :
    RecyclerView.Adapter<DiscoAdapter.DiscoViewHolder>() {

    class DiscoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgCoverDisco: ImageView = itemView.findViewById(R.id.imageView_album_cover)
        val tituloTextView: TextView =
            itemView.findViewById(R.id.textView_titulo_disco)
        val artistaTextView: TextView = itemView.findViewById(R.id.textView_artista_disco)
        val precioTextView: TextView = itemView.findViewById(R.id.textView_precio_disco)

        // listeenr clickeable
        init {
            itemView.setOnClickListener {
                // Acción al hacer clic en un ítem
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    // Haz algo con el ítem en la posición 'position'
                    // val discoClickeado = discos[position]
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoViewHolder {
        // Crea una nueva vista inflando tu layout de ítem.
        val itemView = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_disco_card,
                parent,
                false
            )
        return DiscoViewHolder(itemView)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DiscoViewHolder, position: Int) {
        val discoActual = discos[position]
        holder.imgCoverDisco.setImageResource(discoActual.imageCover)
        holder.tituloTextView.text = discoActual.titulo
        holder.artistaTextView.text = discoActual.artista
        holder.precioTextView.text = "Precio: $${discoActual.precio}"
    }

    override fun getItemCount() = discos.size
}