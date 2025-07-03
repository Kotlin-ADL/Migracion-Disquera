package com.fcterryamigos.disquera.data

import androidx.room.Embedded
import androidx.room.Relation

data class CarritoConProductos(
    @Embedded
    val carrito: Carrito,

    @Relation(
        parentColumn = "id",
        entityColumn = "carrito_id"
    )
    val productos: List<ProductoCarrito>
) {
    // Métodos útiles para cálculos
    fun getTotalItems(): Int {
        return productos.sumOf { it.cantidad }
    }

    fun getTotalPrice(): Double {
        return productos.sumOf {
            it.cantidad * (it.disco?.precio ?: 0.0)
        }
    }

    fun isEmpty(): Boolean {
        return productos.isEmpty()
    }

    fun getProductoCount(): Int {
        return productos.size
    }
}