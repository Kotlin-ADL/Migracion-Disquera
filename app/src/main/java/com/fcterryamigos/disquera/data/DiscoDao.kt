package com.sakhura.conexionbdsqllite.data

import android.content.ContentValues
import android.content.Context
import com.fcterryamigos.disquera.data.Disco

class DiscoDao(context: Context) {
    private val dbHelper = DiscosDBHelper(context)

    fun insertar(disco: Disco): Long {
        val db = DBManager.dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("alta", disco.alta)
            put("ano", disco.ano)
            put("artista", disco.artista)
            put("discografica", disco.discografica)
            put("imagen_portada", disco.imagenPortada)
            put("nombre", disco.nombre)
            put("precio", disco.precio)
            put("genero_id", disco.generoId)
            put("producto_carrito_id", disco.productoCarritoId)
        }
        return db.insert("disco", null, values)
    }

    fun obtenerTodos(): List<Disco> {
        val discos = mutableListOf<Disco>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM disco", null)
        with(cursor) {
            while (moveToNext()) {
                val disco = Disco(
                    id = getInt(getColumnIndexOrThrow("id")),
                    alta = getInt(getColumnIndexOrThrow("alta")),
                    ano = getString(getColumnIndexOrThrow("ano")),
                    artista = getString(getColumnIndexOrThrow("artista")),
                    discografica = getString(getColumnIndexOrThrow("discografica")),
                    imagenPortada = getBlob(getColumnIndexOrThrow("imagen_portada")),
                    nombre = getString(getColumnIndexOrThrow("nombre")),
                    precio = getDouble(getColumnIndexOrThrow("precio")),
                    generoId = getInt(getColumnIndexOrThrow("genero_id")),
                    productoCarritoId = getInt(getColumnIndexOrThrow("producto_carrito_id"))
                )
                discos.add(disco)
            }
            close()
        }
        return discos
    }
}
