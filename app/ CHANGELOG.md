Base de datos: SQLite - Migrada desde MySQL Workbench

#Versión 1.0.0 - 01/07/2025
Migración inicial y estructura base implementada

Base de datos
Se creó la clase DiscosDBHelper.kt con todas las tablas convertidas desde MySQL a SQLite:
    usuario (sin campo avatar)
    carrito
    producto_carrito
    pedido
    producto_pedido
    disco
    genero
    genero_disco (relación N:N)
Se agregaron datos iniciales (INSERT INTO) para:
    3 géneros: Rock, Jazz, Pop
    2 discos (Pink Floyd, Michael Jackson)
    1 usuario, 1 carrito, 1 pedido

Entidades Kotlin (data class)
Se crearon 8 entidades para mapear las tablas:
    Usuario, Carrito, Disco, Genero, GeneroDisco
    ProductoCarrito, ProductoPedido, Pedido

DAO (Data Access Object)
Se implementaron los DAO para todas las entidades con funciones:
    insertar(): inserta registros en SQLite.
    obtenerTodos(): lista todos los registros desde SQLite.

DAOs creados:
    UsuarioDao.kt
    DiscoDao.kt
    GeneroDao.kt
    CarritoDao.kt
    PedidoDao.kt
    ProductoCarritoDao.kt
    ProductoPedidoDao.kt
    GeneroDiscoDao.kt

Observaciones
Se eliminó el campo avatar (tipo LONGBLOB) de usuario por simplicidad en la app.
Relaciones foráneas están declaradas, pero recuerda activar PRAGMA foreign_keys = ON si deseas validación en SQLite.
Se usaron tipos compatibles con SQLite (INTEGER, TEXT, REAL, BLOB).

