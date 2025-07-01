package com.fcterryamigos.disquera.vista

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R

class LoginAdminActivity : AppCompatActivity() {
    override fun onCreate(savedStateHandle: Bundle?) {
        super.onCreate(savedStateHandle)
        setContentView(R.layout.activity_login_admin)

        val emailEditText = findViewById<EditText>(R.id.et_email)
        val passwordEditText = findViewById<EditText>(R.id.et_password)
        val loginButton = findViewById<Button>(R.id.btn_login)
        val registerButton = findViewById<Button>(R.id.btn_ir_registro)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                // Aquí iría la lógica de autenticación real
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener {

            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}