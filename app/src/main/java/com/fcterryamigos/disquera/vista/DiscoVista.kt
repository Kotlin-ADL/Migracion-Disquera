package com.fcterryamigos.disquera.vista

import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R

class DiscoVista : AppCompatActivity() {
    val ivAlbumCover = findViewById<ImageView>(R.id.ivAlbumCover)
    val tvAlbumTitle = findViewById<TextView>(R.id.tvAlbumTitle)
    val tvAlbumArtist = findViewById<TextView>(R.id.tvAlbumArtist)

    val tvAnioData = findViewById<TextView>(R.id.tvAnioData)
    val tvDiscograficaData = findViewById<TextView>(R.id.tvDiscograficaData)
    val tvGeneroData = findViewById<TextView>(R.id.tvGeneroData)

    val tvPrecioData = findViewById<TextView>(R.id.tvPrecioData)
    val btnCarrito = findViewById<Button>(R.id.btnCarrito)
}
