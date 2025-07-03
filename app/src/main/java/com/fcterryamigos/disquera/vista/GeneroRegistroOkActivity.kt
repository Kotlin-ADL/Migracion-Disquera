package com.fcterryamigos.disquera.vista

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R

class GeneroRegistroOkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genero_registro_ok)

        val btn_volver_administracion = findViewById<Button>(R.id.btn_volver_administracion)

        btn_volver_administracion.setOnClickListener {
            setContentView(R.layout.activity_inicio)
        }
    }
}