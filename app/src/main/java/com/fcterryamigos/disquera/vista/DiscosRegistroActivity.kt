
package com.fcterryamigos.disquera.vista

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R

class DiscosRegistroActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etArtista: EditText
    private lateinit var etDiscografica: EditText
    private lateinit var etAnio: EditText
    private lateinit var etGenero: EditText
    private lateinit var etPrecio: EditText
    private lateinit var ivPortada: ImageView
    private lateinit var btnSeleccionarImagen: Button
    private lateinit var btnGuardar: Button

    private var portadaUri: Uri? = null
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discos_registro)

        // Inicializar vistas
        etNombre = findViewById(R.id.etNombre)
        etArtista = findViewById(R.id.etArtista)
        etDiscografica = findViewById(R.id.etDiscografica)
        etAnio = findViewById(R.id.etAnio)
        etGenero = findViewById(R.id.etGenero)
        etPrecio = findViewById(R.id.etPrecio)
        ivPortada = findViewById(R.id.ivPortada)
        btnSeleccionarImagen = findViewById(R.id.btnSeleccionarImagen)
        btnGuardar = findViewById(R.id.btnGuardar)

        // Seleccionar imagen
        btnSeleccionarImagen.setOnClickListener {
            seleccionarImagen()
        }

        // Guardar disco (solo muestra datos por ahora)
        btnGuardar.setOnClickListener {
            guardarDisco()
        }
    }

    private fun seleccionarImagen() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            portadaUri = data.data
            ivPortada.setImageURI(portadaUri)
        }
    }

    private fun guardarDisco() {
        val nombre = etNombre.text.toString().trim()
     val artista = etArtista.text.toString().trim()
        val discografica = etDiscografica.text.toString().trim()
        val anio = etAnio.text.toString().trim()
        val genero = etGenero.text.toString().trim()
        val precio = etPrecio.text.toString().trim()

        // Validación básica
        if (nombre.isEmpty() || artista.isEmpty() || anio.isEmpty() || precio.isEmpty()) {
            Toast.makeText(this, "Por favor complete los campos obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        // Simula guardado (aquí podrías guardar en BD o lista)
        // Por ahora mostramos mensaje y limpiamos campos

        Toast.makeText(this, "Disco \"$nombre\" guardado correctamente", Toast.LENGTH_LONG).show()

        // Limpiar formulario
        etNombre.text.clear()
        etArtista.text.clear()
        etDiscografica.text.clear()
        etAnio.text.clear()
        etGenero.text.clear()
        etPrecio.text.clear()
        ivPortada.setImageResource(R.drawable.ic_launcher_background) // Imagen por defecto
        portadaUri = null
    }

}
