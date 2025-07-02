package com.fcterryamigos.disquera.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "producto_carrito",
    foreignKeys = [
        ForeignKey(
            entity = Carrito::class,
            parentColumns = ["id"],
            childColumns = ["carrito_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Disco::class,
            parentColumns = ["id"],
            childColumns = ["disco_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["carrito_id"]),
        Index(value = ["disco_id"])
    ]
)
data class ProductoCarrito(
    @PrimaryKey
    val id: Int,

    val cantidad: Int,

    @ColumnInfo(name = "carrito_id")
    val carritoId: Int?,

    @ColumnInfo(name = "disco_id")
    val discoId: Int?,

    // Relación con disco (no se almacena en la tabla)
    @Ignore
    val disco: Disco? = null
) {
    // Constructor secundario para Room (sin el disco)
    constructor(id: Int, cantidad: Int, carritoId: Int?, discoId: Int?) :
            this(id, cantidad, carritoId, discoId, null)

    // Métodos útiles
    @Ignore
    fun getPrecioTotal(): Double {
        return cantidad * (disco?.precio ?: 0.0)
    }
}