package com.fcterryamigos.disquera.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "disco",
    foreignKeys = [
        ForeignKey(
            entity = Genero::class,
            parentColumns = ["id"],
            childColumns = ["genero_id"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = ProductoCarrito::class,
            parentColumns = ["id"],
            childColumns = ["producto_carrito_id"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index(value = ["genero_id"]),
        Index(value = ["producto_carrito_id"])
    ]
)
data class Disco(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val alta: String?,

    val ano: String?,

    val artista: String?,

    val discografica: String?,

    @ColumnInfo(name = "imagen_portada")
    val imagen_portada: ByteArray?, // LONGBLOB

    val nombre: String?,

    val precio: Double,

    @ColumnInfo(name = "genero_id")
    val genero_id: Int?,

    @ColumnInfo(name = "producto_carrito_id")
    val producto_carrito_id: Int?
) {
    // Override equals y hashCode por el ByteArray
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Disco

        if (id != other.id) return false
        if (alta != other.alta) return false
        if (ano != other.ano) return false
        if (artista != other.artista) return false
        if (discografica != other.discografica) return false
        if (imagen_portada != null) {
            if (other.imagen_portada == null) return false
            if (!imagen_portada.contentEquals(other.imagen_portada)) return false
        } else if (other.imagen_portada != null) return false
        if (nombre != other.nombre) return false
        if (precio != other.precio) return false
        if (genero_id != other.genero_id) return false
        if (producto_carrito_id != other.producto_carrito_id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + (alta?.hashCode() ?: 0)
        result = 31 * result + (ano?.hashCode() ?: 0)
        result = 31 * result + (artista?.hashCode() ?: 0)
        result = 31 * result + (discografica?.hashCode() ?: 0)
        result = 31 * result + (imagen_portada?.contentHashCode() ?: 0)
        result = 31 * result + (nombre?.hashCode() ?: 0)
        result = 31 * result + precio.hashCode()
        result = 31 * result + (genero_id ?: 0)
        result = 31 * result + (producto_carrito_id ?: 0)
        return result
    }
}