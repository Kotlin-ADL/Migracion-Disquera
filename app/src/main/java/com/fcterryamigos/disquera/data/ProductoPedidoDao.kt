package com.fcterryamigos.disquera.data

import android.content.ContentValues
import android.content.Context
import com.sakhura.conexionbdsqllite.data.DBManager
import com.sakhura.conexionbdsqllite.data.DiscosDBHelper

class ProductoPedidoDao(context: Context) {
    private val dbHelper = DiscosDBHelper(context)

    fun insertar(pp: ProductoPedido): Long {
        val db = DBManager.dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("id", pp.id)
            put("cantidad", pp.cantidad)
            put("disco_id", pp.discoId)
            put("pedido_id", pp.pedidoId)
        }
        return db.insert("producto_pedido", null, values)
    }

    fun obtenerTodos(): List<ProductoPedido> {
        val pps = mutableListOf<ProductoPedido>()
        val db = DBManager.dbHelper.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM producto_pedido", null)

        with(cursor) {
            while (moveToNext()) {
                val item = ProductoPedido(
                    id = getInt(getColumnIndexOrThrow("id")),
                    cantidad = getInt(getColumnIndexOrThrow("cantidad")),
                    discoId = getInt(getColumnIndexOrThrow("disco_id")),
                    pedidoId = getInt(getColumnIndexOrThrow("pedido_id"))
                )
                pps.add(item)
            }
            close()
        }
        return pps
    }

    fun obtenerPorId(id: Int): ProductoPedido? {
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM producto_pedido WHERE id = ?", arrayOf(id.toString()))

        return with(cursor) {
            if (moveToFirst()) {
                val pp = ProductoPedido(
                    id = getInt(getColumnIndexOrThrow("id")),
                    cantidad = getInt(getColumnIndexOrThrow("cantidad")),
                    discoId = getInt(getColumnIndexOrThrow("disco_id")),
                    pedidoId = getInt(getColumnIndexOrThrow("pedido_id"))
                )
                close()
                pp
            } else {
                close()
                null
            }
        }
    }

    fun obtenerPorPedidoId(pedidoId: Int): List<ProductoPedido> {
        val pps = mutableListOf<ProductoPedido>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM producto_pedido WHERE pedido_id = ?", arrayOf(pedidoId.toString()))

        with(cursor) {
            while (moveToNext()) {
                val item = ProductoPedido(
                    id = getInt(getColumnIndexOrThrow("id")),
                    cantidad = getInt(getColumnIndexOrThrow("cantidad")),
                    discoId = getInt(getColumnIndexOrThrow("disco_id")),
                    pedidoId = getInt(getColumnIndexOrThrow("pedido_id"))
                )
                pps.add(item)
            }
            close()
        }
        return pps
    }

    fun obtenerPorDiscoId(discoId: Int): List<ProductoPedido> {
        val pps = mutableListOf<ProductoPedido>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM producto_pedido WHERE disco_id = ?", arrayOf(discoId.toString()))

        with(cursor) {
            while (moveToNext()) {
                val item = ProductoPedido(
                    id = getInt(getColumnIndexOrThrow("id")),
                    cantidad = getInt(getColumnIndexOrThrow("cantidad")),
                    discoId = getInt(getColumnIndexOrThrow("disco_id")),
                    pedidoId = getInt(getColumnIndexOrThrow("pedido_id"))
                )
                pps.add(item)
            }
            close()
        }
        return pps
    }

    fun actualizar(pp: ProductoPedido): Int {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("cantidad", pp.cantidad)
            put("disco_id", pp.discoId)
            put("pedido_id", pp.pedidoId)
        }
        return db.update("producto_pedido", values, "id = ?", arrayOf(pp.id.toString()))
    }

    fun eliminar(id: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("producto_pedido", "id = ?", arrayOf(id.toString()))
    }

    fun eliminarPorPedidoId(pedidoId: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("producto_pedido", "pedido_id = ?", arrayOf(pedidoId.toString()))
    }
}