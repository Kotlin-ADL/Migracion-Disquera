package com.fcterryamigos.disquera.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios",
    indices = [Index(value = ["email"], unique = true)]) // hace un índice único en el campo email
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val apellido: String,
    val email: String,
    val password: String
)