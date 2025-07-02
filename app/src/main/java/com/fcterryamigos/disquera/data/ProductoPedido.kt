package com.fcterryamigos.disquera.data

data class ProductoPedido (
    val id: Int,
    val cantidad: Int,
    val discoId: Int,
    val pedidoId: Int ?
)
