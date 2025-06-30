package com.fcterryamigos.disquera.vista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fcterryamigos.disquera.R
import com.fcterryamigos.disquera.adapter.DiscoAdapter
import com.fcterryamigos.disquera.model.Disco

class DiscosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_discos)

        val recycler = findViewById<RecyclerView>(R.id.recyclerDiscos)
        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnOfers = findViewById<Button>(R.id.btnOffers)
        val btnFeatured = findViewById<Button>(R.id.btnFeatured)

        btnHome.setOnClickListener {
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val discos = listOf(
            Disco("Linkin Park", R.drawable.album_placeholder),
            Disco("Metallica", R.drawable.album_placeholder),
            Disco("Nirvana", R.drawable.album_placeholder),
            Disco("Red Hot", R.drawable.album_placeholder),
            Disco("Eminem", R.drawable.album_placeholder)
        )

        val discsOffers = listOf(
            Disco("System of a Down", R.drawable.album_placeholder),
            Disco("Blink-182", R.drawable.album_placeholder),
            Disco("Green Day", R.drawable.album_placeholder)
        )

        val featuredDiscs = listOf(
            Disco("Peso Pluma", R.drawable.album_placeholder),
            Disco("Natanael Cano", R.drawable.album_placeholder),
            Disco("Junior H", R.drawable.album_placeholder),
            Disco("Kidd Voodoo", R.drawable.album_placeholder),
            Disco("Drake", R.drawable.album_placeholder),
            Disco("Christian Nodal", R.drawable.album_placeholder)
        )

        val adapter = DiscoAdapter(discos)
        recycler.adapter = adapter

        btnOfers.setOnClickListener {
            adapter.actualizarLista(discsOffers)
        }

        btnFeatured.setOnClickListener {
            adapter.actualizarLista(featuredDiscs)
        }

    }
}
