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

        recycler.adapter = DiscoAdapter(discos)
    }
}
