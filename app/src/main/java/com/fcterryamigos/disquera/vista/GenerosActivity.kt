package com.fcterryamigos.disquera.vista

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R
import com.fcterryamigos.disquera.data.GeneroDao
import com.fcterryamigos.disquera.modelo.Genero

class GenerosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generos)

        val tvGenero = findViewById<TextView>(R.id.tvGenero)
        val btnEditar = findViewById<Button>(R.id.btnEditar)
        val btnEliminar = findViewById<Button>(R.id.btnEliminar)
        val etNuevoGenero = findViewById<EditText>(R.id.etNuevoGenero)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val listaView = findViewById<ListView>(R.id.listaGeneros) 

        val dao = GeneroDao(this)
        var generos = dao.obtenerTodos()


        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, generos.map { it.nombre })
        listaView.adapter = adaptador


        if (generos.isNotEmpty()) {
            tvGenero.text = generos[0].nombre
        } else {
            tvGenero.text = "Sin géneros aún"
        }

        btnAgregar.setOnClickListener {
            val nombre = etNuevoGenero.text.toString().trim()

            if (nombre.isNotEmpty()) {
                val nuevoGenero = Genero(nombre = nombre)
                dao.insertar(nuevoGenero)
                Toast.makeText(this, "Género agregado", Toast.LENGTH_SHORT).show()

                etNuevoGenero.text.clear()
                generos = dao.obtenerTodos() // Refrescar
                tvGenero.text = generos.last().nombre


                val nuevoAdaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, generos.map { it.nombre })
                listaView.adapter = nuevoAdaptador
            } else {
                Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_SHORT).show()
            }
        }

        btnEditar.setOnClickListener {
            Toast.makeText(this, "Función editar aún no implementada", Toast.LENGTH_SHORT).show()
        }

        btnEliminar.setOnClickListener {
            Toast.makeText(this, "Función eliminar aún no implementada", Toast.LENGTH_SHORT).show()
        }
    }
}
