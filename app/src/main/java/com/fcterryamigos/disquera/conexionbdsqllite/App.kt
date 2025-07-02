package com.fcterryamigos.disquera.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fcterryamigos.disquera.data.dao.CarritoDao

@Database(
    entities = [
        Usuario::class,
        Carrito::class,
        ProductoCarrito::class,
        Disco::class,
        Genero::class,
        Pedido::class,
        ProductoPedido::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun carritoDao(): CarritoDao
    // Agrega otros DAOs aquí cuando los crees
    // abstract fun usuarioDao(): UsuarioDao
    // abstract fun discoDao(): DiscoDao
}

object DBManager {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "disquera_database"
            )
                .fallbackToDestructiveMigration() // Para desarrollo
                .build()
            INSTANCE = instance
            instance
        }
    }

    // Métodos de conveniencia para acceder a los DAOs
    fun getCarritoDao(context: Context): CarritoDao {
        return getDatabase(context).carritoDao()
    }

    // Método para inicializar (llamado desde App.kt)
    fun initialize(context: Context) {
        getDatabase(context)
    }
}