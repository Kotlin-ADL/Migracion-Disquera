package com.fcterryamigos.disquera.vista
//falta aún la lógica para subir la imagen.
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R


class DiscosEditarActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var etArtista: EditText
    private lateinit var etDiscografica: EditText
    private lateinit var etAno: EditText
    private lateinit var etPrecio: EditText
    private lateinit var spGenero: Spinner
    private lateinit var imgPortada: ImageView
    private lateinit var btnGuardar: Button
    private lateinit var btnSeleccionarImagen: Button

    private var imageUri: Uri? = null
    private val REQUEST_IMAGE_PICK = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discos_editar)

        // Referencias a vistas
        etNombre = findViewById(R.id.etNombre)
        etArtista = findViewById(R.id.etArtista)
        etDiscografica = findViewById(R.id.etDiscografica)
        etAno = findViewById(R.id.etAno)
        etPrecio = findViewById(R.id.etPrecio)
        spGenero = findViewById(R.id.spGenero)
        imgPortada = findViewById(R.id.imgPortada)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnSeleccionarImagen = findViewById(R.id.btnSeleccionarImagen)

        // Cargar géneros en Spinner
        val generos = listOf("Rock", "Pop", "Jazz")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spGenero.adapter = adapter

        // Abrir galería para seleccionar imagen
        btnSeleccionarImagen.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_IMAGE_PICK)
        }

        // Guardar disco (aquí iría la lógica para enviar datos a tu API o BD)
        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val artista = etArtista.text.toString()
            val discografica = etDiscografica.text.toString()
            val ano = etAno.text.toString().toIntOrNull()
            val precio = etPrecio.text.toString().toDoubleOrNull()
            val generoSeleccionado = spGenero.selectedItem.toString()

            // Validaciones
            if (nombre.isEmpty() || artista.isEmpty() || ano == null || precio == null) {
                Toast.makeText(this, "Completa los campos obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Aquí envías los datos a tu backend MySQL mediante API
            Toast.makeText(this, "Disco guardado correctamente", Toast.LENGTH_SHORT).show()
        }
    }

    // Recibir resultado de la selección de imagen
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == RESULT_OK && data != null) {
            imageUri = data.data
            imgPortada.setImageURI(imageUri)
        }
    }
}
