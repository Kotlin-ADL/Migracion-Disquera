package com.fcterryamigos.disquera.vista

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R

class GenerosActivity : AppCompatActivity() {

    // Ejecuta y carga
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Carga el diseño de la pantalla desde el archivo activity_generos.xml
        setContentView(R.layout.activity_generos)

        // Buscamos el TextView por su ID definido en el XML
        val titulo = findViewById<TextView>(R.id.tituloGeneros)

        // Cambiamos el texto del título (opcional)
        titulo.text = "Géneros musicales disponibles"

        // Busca el botón por su ID definido en el XML
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        // Cuando se hace clic en el botón, cerramos esta pantalla y volvemos atrás
        btnVolver.setOnClickListener {
            finish()
        }
    }
}