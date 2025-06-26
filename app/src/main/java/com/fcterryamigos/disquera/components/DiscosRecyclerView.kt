package com.fcterryamigos.disquera.components

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

    //iniciar los elementos/variables de la vista
    class DiscoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgCoverDisco: ImageView =
            itemView.findViewById(R.id.imageView_album_cover_itemDiscoCard)
        val tituloTextView: TextView =
            itemView.findViewById(R.id.textView_titulo_itemDiscoCard)
        val artistaTextView: TextView = itemView.findViewById(R.id.textView_artista_itemDiscoCard)
        val generoTextView: TextView = itemView.findViewById(R.id.textView_genero_itemDiscoCard)
        val precioTextView: TextView = itemView.findViewById(R.id.textView_precio_itemDiscoCard)
        val btnAnadirCarrito: Button = itemView.findViewById(R.id.btn_anadir_carrito_itemDiscoCard)

    }

    // Inflar el layout de ítemCard
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

    //Asigna los datos a los elementos de la vista.
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DiscoViewHolder, position: Int) {
        val discoActual = discos[position]
        holder.imgCoverDisco.setImageResource(discoActual.imageCover)
        holder.tituloTextView.text = discoActual.titulo
        holder.artistaTextView.text = discoActual.artista
        holder.generoTextView.text = discoActual.genero
        holder.precioTextView.text = "Precio: $${discoActual.precio}"
        holder.btnAnadirCarrito.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Añadido al carrito(Prueba click)",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    //Devuelve el numero total de elementos en la lista
    override fun getItemCount() = discos.size
}