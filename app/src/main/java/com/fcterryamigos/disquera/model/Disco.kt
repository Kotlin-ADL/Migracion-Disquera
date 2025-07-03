package com.fcterryamigos.disquera.model

import androidx.annotation.DrawableRes

/**Clase de datos para informacion de cada Disco
 * @param imageCover Imagen del album
 * @param titulo Titulo del album
 * @param artista Artista del album
 * @param precio Precio del album
 * @param genero Genero del album*/
data class Disco(
    @DrawableRes val imageCover: Int,
    val titulo: String,
    val artista: String,
    val precio: Double,
    val genero: String
)
