package com.fcterryamigos.disquera.vista

import android.os.Bundle
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.fcterryamigos.disquera.R

class PedidosDetalleActivity: AppCompatActivity() {



    // Datos ficticios
    private val nombre = "Michael Scott"
    private val direccion = "Calle Alameda"
    private val provincia = "Santiago"

    private val tipoTarjeta = "Débito"
    private val titular = "Michael Scott"
    private val numeroTarjeta = "1234-5678-9012"

    private val estadoPedido = "RECIBIDO POR EL CLIENTE"

    private val productos = listOf(
        mapOf("nombre" to "Disco 1", "precio" to 15.99, "cantidad" to 2),
        mapOf("nombre" to "Disco 2", "precio" to 9.99, "cantidad" to 1)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos_detalle)

        // Referencias a vistas
        findViewById<TextView>(R.id.tvNombre).text = "Nombre: $nombre"
        findViewById<TextView>(R.id.tvDireccion).text = "Dirección: $direccion"
        findViewById<TextView>(R.id.tvProvincia).text = "Provincia: $provincia"

        findViewById<TextView>(R.id.tvTipoTarjeta).text = "Tipo de tarjeta: $tipoTarjeta"
        findViewById<TextView>(R.id.tvTitular).text = "Titular: $titular"
        findViewById<TextView>(R.id.tvNumeroTarjeta).text = "Número de tarjeta: $numeroTarjeta"

        findViewById<TextView>(R.id.tvEstadoPedido).text = "$estadoPedido"

        // Referencia al color
        val colorBlanco = getColor(R.color.text_white)

        val layoutProductos = findViewById<LinearLayout>(R.id.layoutProductos)

        val paddingBottom = (4 * resources.displayMetrics.density).toInt()
        val layoutPaddingBottom = (8 * resources.displayMetrics.density).toInt()

        for (producto in productos) {
            val productoView = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(0, 0, 0, layoutPaddingBottom)
                layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }


            val nombreText = TextView(this).apply {
                text = "Nombre: ${producto["nombre"]}"
                setTextColor(colorBlanco)
                setPadding(0, 0, 0, paddingBottom)
            }

            val precioText = TextView(this).apply {
                text = "Precio/unidad: \$${producto["precio"]}"
                setTextColor(colorBlanco)
                setPadding(0, 0, 0, paddingBottom)
            }

            val cantidadText = TextView(this).apply {
                text = "Cantidad: ${producto["cantidad"]}"
                setTextColor(colorBlanco)
                setPadding(0, 0, 0, paddingBottom)
            }

            productoView.addView(nombreText)
            productoView.addView(precioText)
            productoView.addView(cantidadText)

            layoutProductos.addView(productoView)
        }

    }
}