package com.fcterryamigos.disquera.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "usuario",
    indices = [
        Index(value = ["email"], unique = true)
    ]
)
data class Usuario(
    @PrimaryKey
    val id: Int,

    val email: String,

    val nombre: String,

    val pais: String,

    val pass: String,

    val tel: String,

    @ColumnInfo(name = "carrito_id")
    val carrito_id: Int?
)