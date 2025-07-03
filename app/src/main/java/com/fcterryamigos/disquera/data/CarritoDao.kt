package com.fcterryamigos.disquera.data.dao

import androidx.room.*
import com.fcterryamigos.disquera.data.Carrito
import com.fcterryamigos.disquera.data.ProductoCarrito
import kotlinx.coroutines.flow.Flow

@Dao
interface CarritoDao {

    // ========== OPERACIONES BÁSICAS CARRITO ==========

    @Query("SELECT * FROM carrito WHERE id = :carritoId")
    suspend fun getCarritoById(carritoId: Int): Carrito?

    @Query("SELECT * FROM carrito WHERE usuario_id = :usuarioId")
    suspend fun getCarritoByUsuario(usuarioId: Int): Carrito?

    @Query("SELECT * FROM carrito WHERE usuario_id = :usuarioId")
    fun getCarritoByUsuarioFlow(usuarioId: Int): Flow<Carrito?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCarrito(carrito: Carrito): Long

    @Update
    suspend fun updateCarrito(carrito: Carrito)

    @Delete
    suspend fun deleteCarrito(carrito: Carrito)

    @Query("DELETE FROM carrito WHERE id = :carritoId")
    suspend fun deleteCarritoById(carritoId: Int)

    // ========== OPERACIONES CON PRODUCTOS DEL CARRITO ==========

    @Query("""
        SELECT pc.* FROM producto_carrito pc 
        WHERE pc.carrito_id = :carritoId
    """)
    suspend fun getProductosEnCarrito(carritoId: Int): List<ProductoCarrito>

    @Query("""
        SELECT pc.* FROM producto_carrito pc 
        WHERE pc.carrito_id = :carritoId
    """)
    fun getProductosEnCarritoFlow(carritoId: Int): Flow<List<ProductoCarrito>>

    // Obtener carrito con sus productos (usando relación)
    @Query("""
        SELECT c.*, 
               pc.id as pc_id, pc.cantidad as pc_cantidad, pc.disco_id as pc_disco_id,
               d.id as disco_id, d.nombre as disco_nombre, d.artista as disco_artista, 
               d.precio as disco_precio, d.imagen_portada as disco_imagen
        FROM carrito c
        LEFT JOIN producto_carrito pc ON c.id = pc.carrito_id
        LEFT JOIN disco d ON pc.disco_id = d.id
        WHERE c.id = :carritoId
    """)
    suspend fun getCarritoConProductosRaw(carritoId: Int): List<Map<String, Any>>

    // Versión más limpia usando data classes
    @Transaction
    @Query("SELECT * FROM carrito WHERE id = :carritoId")
    suspend fun getCarritoConProductos(carritoId: Int): CarritoConProductos?

    // ========== OPERACIONES DE CARRITO POR USUARIO ==========

    @Query("""
        SELECT COUNT(*) FROM producto_carrito pc 
        INNER JOIN carrito c ON pc.carrito_id = c.id 
        WHERE c.usuario_id = :usuarioId
    """)
    suspend fun getTotalItemsEnCarrito(usuarioId: Int): Int

    @Query("""
        SELECT COUNT(*) FROM producto_carrito pc 
        INNER JOIN carrito c ON pc.carrito_id = c.id 
        WHERE c.usuario_id = :usuarioId
    """)
    fun getTotalItemsEnCarritoFlow(usuarioId: Int): Flow<Int>

    @Query("""
        SELECT COALESCE(SUM(pc.cantidad * d.precio), 0.0) as total
        FROM producto_carrito pc 
        INNER JOIN carrito c ON pc.carrito_id = c.id
        INNER JOIN disco d ON pc.disco_id = d.id
        WHERE c.usuario_id = :usuarioId
    """)
    suspend fun getTotalPrecioCarrito(usuarioId: Int): Double

    // ========== OPERACIONES DE LIMPIEZA ==========

    @Query("DELETE FROM producto_carrito WHERE carrito_id = :carritoId")
    suspend fun limpiarCarrito(carritoId: Int)

    @Query("""
        DELETE FROM producto_carrito 
        WHERE carrito_id IN (SELECT id FROM carrito WHERE usuario_id = :usuarioId)
    """)
    suspend fun limpiarCarritoPorUsuario(usuarioId: Int)

    // ========== UTILIDADES ==========

    @Query("""
        SELECT EXISTS(
            SELECT 1 FROM carrito 
            WHERE usuario_id = :usuarioId
        )
    """)
    suspend fun usuarioTieneCarrito(usuarioId: Int): Boolean

    // Crear carrito automáticamente si no existe
    @Transaction
    suspend fun getOrCreateCarrito(usuarioId: Int): Carrito {
        var carrito = getCarritoByUsuario(usuarioId)
        if (carrito == null) {
            val nuevoId = (System.currentTimeMillis() % Int.MAX_VALUE).toInt()
            carrito = Carrito(id = nuevoId, usuarioId = usuarioId)
            insertCarrito(carrito)
        }
        return carrito
    }
}