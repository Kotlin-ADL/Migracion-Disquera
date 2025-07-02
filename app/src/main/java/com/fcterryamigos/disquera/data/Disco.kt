package com.fcterryamigos.disquera.data

data class Disco (
    val  id 			       : Int,
    val  alta 			       : String ?,
    val  ano 			       : String ?,
    val  artista 		       : String ?,
    val  discografica 	       : String ?,
    val  imagen_portada        : ByteArray ?, // BLOB
    val  nombre 		       : String ?,
    val  precio 		       : Double,
    val  genero_id 		       : Int ?,
    val  producto_carrito_id   : Int ?
)