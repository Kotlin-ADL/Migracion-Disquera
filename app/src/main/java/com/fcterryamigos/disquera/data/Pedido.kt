package com.fcterryamigos.disquera.data

data class Pedido (
    val id: Int,
    val direccion: String?,
    val estado: String?,
    val nombreCompleto: String?,
    val numeroTarjeta: String?,
    val observaciones: String?,
    val provincia: String?,
    val regalo: String?,
    val tipoTarjeta: String?,
    val titularTargeta: String?,
    val titularTarjeta: String?,
    val usuarioId: Int

)