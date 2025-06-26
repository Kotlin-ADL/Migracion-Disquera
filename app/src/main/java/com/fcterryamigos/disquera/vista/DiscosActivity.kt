package com.fcterryamigos.disquera.vista

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isGone
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fcterryamigos.disquera.R
import com.fcterryamigos.disquera.components.DiscoAdapter
import com.fcterryamigos.disquera.model.Disco

/**Esta activity incluye una barra de busqueda, filtros y muestra una lista de discos con sus detalles.*/
class DiscosActivity : AppCompatActivity() {

    //variables constantes
    private val precios = arrayOf(
        20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150, 160, 170, 180, 190, 200
    )

    //variables leteinit
    private lateinit var searchBar: SearchView
    private lateinit var btnFiltroBusqueda: Button
    private lateinit var filtrosLayout: LinearLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinnerArtistas: Spinner
    private lateinit var spinnerPrecio: Spinner

    //variable para datos ficticios.
    private lateinit var datosDeDiscos: List<Disco>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discos)

        //carga datos ficticios
        datosDeDiscos = cargarDatosDeDiscos()

        //inicio de componentes
        initSearchBar()
        initBtnOcultarLayoutFiltros()
        initBtnFiltroArtista()
        initBtnFiltroPrecio()
        initRecyclerView()

    }

    /*
    * ************************ Funciones de inicialización de componentes ************
     */

    private fun initSearchBar() {
        searchBar = findViewById(R.id.searchView_activity_discos)
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

    private fun initBtnOcultarLayoutFiltros() {
        filtrosLayout = findViewById(R.id.layout_filtros_activity_discos)
        btnFiltroBusqueda = findViewById(R.id.btn_filtros_activity_discos)
        filtrosLayout.visibility = LinearLayout.GONE
        btnFiltroBusqueda.setOnClickListener {
            if (filtrosLayout.isGone) {
                filtrosLayout.visibility = LinearLayout.VISIBLE
            } else {
                filtrosLayout.visibility = LinearLayout.GONE
            }
        }
    }

    private fun initBtnFiltroArtista() {
        spinnerArtistas = findViewById(R.id.spinner_artistas_activity_discos)
        //transforma la lista en nueva lista de solo artistas, sin repetir.
        val nombreDeArtistas = cargarDatosDeDiscos().map { it.artista }.distinct()

        spinnerArtistas.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            nombreDeArtistas
        )

        spinnerArtistas.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                mesage("Artista seleccionado: ${nombreDeArtistas[position]}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun initBtnFiltroPrecio() {
        spinnerPrecio = findViewById(R.id.spinner_precio_activity_discos)
        spinnerPrecio.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            precios
        )

        spinnerPrecio.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                mesage("Precio seleccionado: ${precios[position]}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView_activity_discos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = DiscoAdapter(datosDeDiscos)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
    }

    /*
        ---------------------- FIN Funciones de inicialización de componentes --------------------------------------
     */

    /**Datos ficticios para recargar la lista de discos*/
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

    /**Fcn para mostrar un mensaje en pantalla. Es para pruebas*/
    private fun mesage(mesage: String) {
        Toast.makeText(this, mesage, Toast.LENGTH_SHORT).show()
    }

}