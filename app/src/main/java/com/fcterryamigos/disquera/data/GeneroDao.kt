package com.fcterryamigos.disquera.data

import android.content.ContentValues
import android.content.Context
import com.sakhura.conexionbdsqllite.data.DiscosDBHelper

class GeneroDao(context: Context) {
    private val dbHelper = DiscosDBHelper(context)

    fun insertar(genero: Genero): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("id", genero.id)
            put("nombre", genero.nombre)
        }
        return db.insert("genero", null, values)
    }

    fun obtenerTodos(): List<Genero> {
        val generos = mutableListOf<Genero>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM genero", null)
        with(cursor) {
            while (moveToNext()) {
                val genero = Genero(
                    id = getInt(getColumnIndexOrThrow("id")),
                    nombre = getString(getColumnIndexOrThrow("nombre"))
                )
                generos.add(genero)
            }
            close()
        }
        return generos
    }
}