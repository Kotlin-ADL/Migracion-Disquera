package com.fcterryamigos.disquera.vista

<<<<<<< HEAD
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.MainActivity
import com.fcterryamigos.disquera.R

class UsuariosActivity: AppCompatActivity() {
    override fun onCreate(savedStateHandle: Bundle?){
        super.onCreate(savedStateHandle)
        setContentView(R.layout.activity_usuarios)

        val backBtn = findViewById<ImageButton>(R.id.back_btn)
        val newBtn = findViewById<Button>(R.id.new_product_btn)
        val manageBtn = findViewById<Button>(R.id.manage_product_btn)
        val viewBtn = findViewById<Button>(R.id.view_products_btn)
        val pendingBtn = findViewById<Button>(R.id.pending_btn)
        val settingsBtn = findViewById<Button>(R.id.settings_btn)
        val changePassBtn = findViewById<Button>(R.id.change_pass_btn)

        backBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        newBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        manageBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        viewBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        pendingBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        settingsBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        changePassBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
=======
class UsuariosActivity {
    /*Testing creación de rama felipeazs*/
}
>>>>>>> felipeazs
