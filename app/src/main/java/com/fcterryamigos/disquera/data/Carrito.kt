package com.fcterryamigos.disquera.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(
    tableName = "carrito",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id"],
            childColumns = ["usuario_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Carrito(
    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "usuario_id")
    val usuarioId: Int?,

    // Lista de productos en el carrito (no se almacena en la tabla carrito)
    @Ignore
    val productos: List<ProductoCarrito> = emptyList()
) {
    // Constructor secundario para Room (ignora la lista de productos)
    constructor(id: Int, usuarioId: Int?) : this(id, usuarioId, emptyList())

    // Métodos útiles para el carrito
    @Ignore
    fun getTotalItems(): Int {
        return productos.sumOf { it.cantidad }
    }

    @Ignore
    fun getTotalPrice(): Double {
        return productos.sumOf { it.cantidad * (it.disco?.precio ?: 0.0) }
    }

    @Ignore
    fun isEmpty(): Boolean {
        return productos.isEmpty()
    }
}