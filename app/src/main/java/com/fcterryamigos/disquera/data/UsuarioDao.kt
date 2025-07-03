package com.fcterryamigos.disquera.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.sakhura.conexionbdsqllite.data.DiscosDBHelper

class UsuarioDao (context: Context) {
    private val dbHelper = DiscosDBHelper(context)

    fun insertar(usuario: Usuario): Long {
        val db:SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("id", usuario.id)
            put("email", usuario.email)
            put("nombre", usuario.nombre)
            put("pais", usuario.pais)
            put("pass", usuario.pass)
            put("tel", usuario.tel)
            put("carrito_id", usuario.carritoId)

        }
        return  db.insert("usuario", null, values)
    }

    fun obtenerTodos(): List<Usuario> {
        val usuarios = mutableListOf<Usuario>()
        val db: SQLiteDatabase = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM usuario", null)
                with(cursor){
                    while(moveToNext()){
                        val usuarios = Usuario(
                                    id = getInt(getColumnIndexOrThrow("id")),
                                    email = getString(getColumnIndexOrThrow("email")),
                                    nombre = getString(getColumnIndexOrThrow("nombre")),
                                    pais = getString(getColumnIndexOrThrow("pais")),
                                    pass = getString(getColumnIndexOrThrow("pass")),
                                    tel = getString(getColumnIndexOrThrow("tel")),
                                    carritoId = getInt(getColumnIndexOrThrow("carrito_id"))
                        )
                        usuarios.add(usuarios)
                    }
                    close()
        }
            return usuarios
    }

}