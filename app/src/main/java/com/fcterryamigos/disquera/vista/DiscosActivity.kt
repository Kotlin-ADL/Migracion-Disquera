package com.fcterryamigos.disquera.vista

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fcterryamigos.disquera.R
import com.fcterryamigos.disquera.components.Disco
import com.fcterryamigos.disquera.components.DiscoAdapter

class DiscosActivity : AppCompatActivity() {

    //variables leteinit
    private lateinit var searchBar: SearchView
    private lateinit var btnFiltroBusqueda: Button
    private lateinit var filtrosLayout: LinearLayout
    private lateinit var recyclerView: RecyclerView

    //Datos
    private lateinit var datosDeDiscos: List<Disco>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discos)

        //inicializacion
        searchBar = findViewById(R.id.searchView_activity_discos)
        btnFiltroBusqueda = findViewById(R.id.btn_filtros_activity_discos)
        filtrosLayout = findViewById(R.id.layout_filtros_activity_discos)
        filtrosLayout.visibility = LinearLayout.GONE
        initSearchBar()

        //carga datos
        datosDeDiscos = cargarDatosDeDiscos()

        //Recyclerview
        recyclerView = findViewById(R.id.recyclerView_activity_discos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DiscoAdapter(datosDeDiscos)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        //Fin recyclerview.----

        btnFiltroBusqueda.setOnClickListener {
            if (filtrosLayout.isGone) {
                filtrosLayout.visibility = LinearLayout.VISIBLE
            } else {
                filtrosLayout.visibility = LinearLayout.GONE
            }
        }
    }

    private fun initSearchBar() {
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Acción cuando el usuario presiona "buscar"
                if (query != null) {
                    Log.d("SearchLayout", "Query eenviada: $query")
                }
                searchBar.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Acción mientras el usuario escribe
                if (newText != null) {
                    Log.d("SearchLayout", "Query cambia: $newText")
                }
                return true
            }
        })
    }

    private fun cargarDatosDeDiscos(): List<Disco> {
        val placeholderImage = R.drawable.placeholder
        return listOf(
            Disco(placeholderImage, "Comedown Machine", "The Strokes", 27.99, "Indie Rock"),
            Disco(placeholderImage, "AM", "Arctic Monkeys", 22.50, "Indie Rock"),
            Disco(placeholderImage, "Currents", "Tame Impala", 30.00, "Psychedelic Pop"),
            Disco(placeholderImage, "Random Access Memories", "Daft Punk", 25.90, "Electronic"),
            Disco(placeholderImage, "Abbey Road", "The Beatles", 19.75, "Rock"),
            Disco(
                placeholderImage,
                "The Dark Side of the Moon",
                "Pink Floyd",
                24.99,
                "Progressive Rock"
            ),
            Disco(placeholderImage, "OK Computer", "Radiohead", 21.80, "Alternative Rock"),
            Disco(placeholderImage, "Nevermind", "Nirvana", 18.99, "Grunge"),
            Disco(placeholderImage, "Back to Black", "Amy Winehouse", 20.50, "Soul"),
            Disco(placeholderImage, "Rumours", "Fleetwood Mac", 23.40, "Soft Rock"),
            Disco(placeholderImage, "Led Zeppelin IV", "Led Zeppelin", 26.10, "Hard Rock"),
            Disco(placeholderImage, "Thriller", "Michael Jackson", 15.99, "Pop")
        )
    }

}