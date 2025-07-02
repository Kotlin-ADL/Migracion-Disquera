package com.sakhura.conexionbdsqllite.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DiscosDBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "discos.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Tabla genero
        db.execSQL("""
            CREATE TABLE genero (
                id INTEGER PRIMARY KEY,
                nombre TEXT
            );
        """)

        // Tabla disco
        db.execSQL("""
            CREATE TABLE disco (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                alta INTEGER NOT NULL,
                ano TEXT NOT NULL,
                artista TEXT,
                discografica TEXT,
                imagen_portada BLOB,
                nombre TEXT,
                precio REAL NOT NULL,
                genero_id INTEGER,
                producto_carrito_id INTEGER,
                FOREIGN KEY (genero_id) REFERENCES genero(id),
                FOREIGN KEY (producto_carrito_id) REFERENCES producto_carrito(id)
            );
        """)

        // Tabla carrito
        db.execSQL("""
            CREATE TABLE carrito (
                id INTEGER PRIMARY KEY,
                usuario_id INTEGER,
                FOREIGN KEY (usuario_id) REFERENCES usuario(id)
            );
        """)

        // Tabla usuario
        db.execSQL("""
    CREATE TABLE usuario (
        id INTEGER PRIMARY KEY,
        email TEXT UNIQUE,
        nombre TEXT,
        pais TEXT,
        pass TEXT,
        tel TEXT,
        carrito_id INTEGER,
        FOREIGN KEY (carrito_id) REFERENCES carrito(id)
    );
""")

        // Tabla pedido
        db.execSQL("""
            CREATE TABLE pedido (
                id INTEGER PRIMARY KEY,
                direccion TEXT,
                estado TEXT,
                nombre_completo TEXT,
                numero_tarjeta TEXT,
                observaciones TEXT,
                provincia TEXT,
                regalo TEXT,
                tipo_tarjeta TEXT,
                titular_targeta TEXT,
                titular_tarjeta TEXT,
                usuario_id INTEGER NOT NULL,
                FOREIGN KEY (usuario_id) REFERENCES usuario(id)
            );
        """)

        // Tabla producto_carrito
        db.execSQL("""
            CREATE TABLE producto_carrito (
                id INTEGER PRIMARY KEY,
                cantidad INTEGER NOT NULL,
                carrito_id INTEGER,
                disco_id INTEGER,
                FOREIGN KEY (carrito_id) REFERENCES carrito(id),
                FOREIGN KEY (disco_id) REFERENCES disco(id)
            );
        """)

        // Tabla producto_pedido
        db.execSQL("""
            CREATE TABLE producto_pedido (
                id INTEGER PRIMARY KEY,
                cantidad INTEGER NOT NULL,
                disco_id INTEGER,
                pedido_id INTEGER,
                FOREIGN KEY (disco_id) REFERENCES disco(id),
                FOREIGN KEY (pedido_id) REFERENCES pedido(id)
            );
        """)

        // Tabla genero_disco (relación N:N)
        db.execSQL("""
            CREATE TABLE genero_disco (
                genero_id INTEGER,
                disco_id INTEGER UNIQUE,
                FOREIGN KEY (genero_id) REFERENCES genero(id),
                FOREIGN KEY (disco_id) REFERENCES disco(id)
            );
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS genero_disco")
        db.execSQL("DROP TABLE IF EXISTS producto_pedido")
        db.execSQL("DROP TABLE IF EXISTS producto_carrito")
        db.execSQL("DROP TABLE IF EXISTS pedido")
        db.execSQL("DROP TABLE IF EXISTS usuario")
        db.execSQL("DROP TABLE IF EXISTS carrito")
        db.execSQL("DROP TABLE IF EXISTS disco")
        db.execSQL("DROP TABLE IF EXISTS genero")
        onCreate(db)
    }
}
