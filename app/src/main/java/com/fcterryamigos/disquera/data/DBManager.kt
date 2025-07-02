package com.sakhura.conexionbdsqllite.data

import android.content.Context

object DBManager {
    lateinit var dbHelper: DiscosDBHelper

    fun init(context: Context) {
        dbHelper = DiscosDBHelper(context)
    }
}
