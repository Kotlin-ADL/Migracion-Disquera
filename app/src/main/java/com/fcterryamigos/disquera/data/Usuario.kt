package com.fcterryamigos.disquera.data

data class Usuario (
    val id: Int,
    val email: String,
    val nombre: String,
    val pais: String,
    val pass: String,
    val tel: String,
    val carrito_id: Int?

)