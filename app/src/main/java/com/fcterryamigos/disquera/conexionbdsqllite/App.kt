package com.fcterryamigos.disquera.conexionbdsqllite

import android.app.Application
import com.fcterryamigos.disquera.data.DBManager

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Inicializa la base de datos centralizada
        DBManager.init(this)
    }
}