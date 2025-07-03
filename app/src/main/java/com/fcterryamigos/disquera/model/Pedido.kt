
package com.fcterryamigos.disquera.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date // Aunque usaremos Long, es buena práctica si trabajas con Date en la app

@Entity(tableName = "pedidos") // Anotación para indicar que es una tabla de Room, y su nombre
data class Pedido(
    @PrimaryKey(autoGenerate = true) // Clave primaria, autoincremental
    val id: Int = 0, // Tipo Int para el ID autogenerado

    @ColumnInfo(name = "usuario_id") // Nombre de la columna en la base de datos
    val usuarioId: String, // Clave foránea que referencia el ID del Usuario (asumimos String)

    @ColumnInfo(name = "fecha_pedido")
    val fechaPedido: Long = System.currentTimeMillis(), // Fecha de creación como timestamp (Long)

    @ColumnInfo(name = "nombre_completo")
    var nombreCompleto: String, // Información del cliente para el envío

    @ColumnInfo(name = "direccion")
    var direccion: String,

    @ColumnInfo(name = "provincia")
    var provincia: String,

    @ColumnInfo(name = "titular_tarjeta")
    var titularTarjeta: String, // Información de pago

    @ColumnInfo(name = "numero_tarjeta")
    var numeroTarjeta: String, // Cuidado: Solo para fines educativos, en producción usar tokenización

    @ColumnInfo(name = "tipo_tarjeta")
    var tipoTarjeta: String,

    @ColumnInfo(name = "estado")
    var estado: String, // Ej: "Pendiente", "Procesando", "Enviado", "Entregado", "Cancelado"

    @ColumnInfo(name = "regalo")
    var regalo: String? = null, // Campo opcional (puede ser nulo)

    @ColumnInfo(name = "observaciones")
    var observaciones: String? = null, // Campo opcional (puede ser nulo)

    @ColumnInfo(name = "total_pedido")
    var totalPedido: Double // Total monetario del pedido
)