package com.fcterryamigos.disquera.vista

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R

class GeneroRegistroActivity : AppCompatActivity() {

    private val REQUEST_IMAGE_PICK = 100
    private lateinit var imageViewGenero: ImageView
    private var uriImagenSeleccionada: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genero_registro)

        val input_genero_registro = findViewById<EditText>(R.id.text_input_genero_registro)
        val btn_enviar_genero_registro = findViewById<Button>(R.id.btn_enviar_genero_registro)
        val btn_seleccionar_imagen = findViewById<Button>(R.id.btn_seleccionar_imagen)
        imageViewGenero = findViewById(R.id.imagen_genero)

        btn_seleccionar_imagen.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_IMAGE_PICK)
        }

        btn_enviar_genero_registro.setOnClickListener {
            val textoGenero = input_genero_registro.text.toString().trim()

            if (textoGenero.isNotEmpty() && uriImagenSeleccionada != null) {
                println("Registrar género: $textoGenero")
                println("URI de la imagen: $uriImagenSeleccionada")
                // Aquí puedes luego guardar en base de datos o enviar al backend
            } else {
                println("Por favor ingresa un nombre y selecciona una imagen.")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            uriImagenSeleccionada = data.data
            imageViewGenero.setImageURI(uriImagenSeleccionada)
        }
    }
}
