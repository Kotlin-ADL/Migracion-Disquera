package com.fcterryamigos.disquera.vista

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R

class InicioActivity : AppCompatActivity() {

    private lateinit var imgSwitcher: ImageSwitcher
    private lateinit var btnVerDisco: Button
    private lateinit var btnRegistrarse: Button

    //Imagenes del banner
    private var bannerImgs = intArrayOf(
        R.drawable.img_banner_1,
        R.drawable.img_banner_2,
        R.drawable.img_banner_3
    )
    private var index = 0 //para ir cambiando de imagen por indice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        initImageHero()
        initButtons()

    }

    /**Inicia las imagenes del banner y su ciclo*/
    private fun initImageHero() {
        imgSwitcher = findViewById(R.id.imageSwitcher_activity_inicio)
        imgSwitcher.setFactory({
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        })
        imgSwitcher.setImageResource(bannerImgs[index])

        //Animaciones
        val imgIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left
        )
        imgSwitcher.inAnimation = imgIn

        val imgOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right
        )
        imgSwitcher.outAnimation = imgOut

        //Inicia ciclo de imagenes
        val delay: Long = 3000
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                index++
                if (index == bannerImgs.size) index = 0
                imgSwitcher.setImageResource(bannerImgs[index])
                handler.postDelayed(this, delay) // cambia la img cada segundos dados
            }
        }
        handler.postDelayed(runnable, delay) // inicia el ciclo
    }

    /**Inicia los botones de la vista*/
    private fun initButtons() {
        btnVerDisco = findViewById(R.id.btn_verDiscos_activity_inicio)
        btnRegistrarse = findViewById(R.id.btn_registrarse_activity_inicio)

        btnVerDisco.setOnClickListener {
            message("Ir a ver discos")
        }
        btnRegistrarse.setOnClickListener {
            message("Ir a registrarse")
        }

    }

    //Para borrar luego
    private fun message(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}

