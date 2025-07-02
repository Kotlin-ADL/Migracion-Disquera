package com.fcterryamigos.disquera.data

import android.content.ContentValues
import android.content.Context
import com.sakhura.conexionbdsqllite.data.DiscosDBHelper

class GeneroDiscoDao(context: Context) {
    private val dbHelper = DiscosDBHelper(context)

    fun insertar(generoDisco: GeneroDisco): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("genero_id", generoDisco.generoId)
            put("disco_id", generoDisco.discoId)
        }
        return db.insert("genero_disco", null, values)
    }

    fun obtenerTodos(): List<GeneroDisco> {
        val generoDiscos = mutableListOf<GeneroDisco>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM genero_disco", null)

        with(cursor) {
            while (moveToNext()) {
                val generoDisco = GeneroDisco(
                    generoId = getInt(getColumnIndexOrThrow("genero_id")),
                    discoId = getInt(getColumnIndexOrThrow("disco_id"))
                )
                generoDiscos.add(generoDisco)
            }
            close()
        }
        return generoDiscos
    }

    fun obtenerPorGeneroId(generoId: Int): List<GeneroDisco> {
        val generoDiscos = mutableListOf<GeneroDisco>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM genero_disco WHERE genero_id = ?", arrayOf(generoId.toString()))

        with(cursor) {
            while (moveToNext()) {
                val generoDisco = GeneroDisco(
                    generoId = getInt(getColumnIndexOrThrow("genero_id")),
                    discoId = getInt(getColumnIndexOrThrow("disco_id"))
                )
                generoDiscos.add(generoDisco)
            }
            close()
        }
        return generoDiscos
    }

    fun obtenerPorDiscoId(discoId: Int): List<GeneroDisco> {
        val generoDiscos = mutableListOf<GeneroDisco>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM genero_disco WHERE disco_id = ?", arrayOf(discoId.toString()))

        with(cursor) {
            while (moveToNext()) {
                val generoDisco = GeneroDisco(
                    generoId = getInt(getColumnIndexOrThrow("genero_id")),
                    discoId = getInt(getColumnIndexOrThrow("disco_id"))
                )
                generoDiscos.add(generoDisco)
            }
            close()
        }
        return generoDiscos
    }

    fun eliminar(generoId: Int, discoId: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("genero_disco", "genero_id = ? AND disco_id = ?", arrayOf(generoId.toString(), discoId.toString()))
    }

    fun eliminarPorGeneroId(generoId: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("genero_disco", "genero_id = ?", arrayOf(generoId.toString()))
    }

    fun eliminarPorDiscoId(discoId: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("genero_disco", "disco_id = ?", arrayOf(discoId.toString()))
    }
}