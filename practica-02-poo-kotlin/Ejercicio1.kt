class Producto {
    
    var precio: Double = 0.0
        get() = field
        set(value) {
            if (value >= 0.0) {
                field = value
            } else {
                println("error: el precio no puede ser negativo. Se mantendrá en $field")
            }
        }

    var descuento: Double = 0.0
        get() = field
        set(value) {
            if (value in 0.0..100.0) {
                field = value
            } else {
                println("error: el descuento debe estar entre 0 y 100. Se mantendrá en $field")
            }
        }

    fun calcularPrecioFinal(): Double {
        return precio - (precio * (descuento / 100.0))
    }
}

fun main() {
    println("sistema de producto y descuentos")
    
    val producto = Producto()
    
    print("ingresa el precio del producto: ")
    val inputPrecio = readln().toDoubleOrNull()
    
    // Valido la entrada tal como lo hacías en la práctica 1
    if (inputPrecio == null) {
        println("por favor ingresa un precio numérico válido.")
        return
    }
    // Utilizamos el set (se valida automáticamente)
    producto.precio = inputPrecio
    
    print("ingresa el porcentaje de descuento (0 a 100): ")
    val inputDescuento = readln().toDoubleOrNull()
    
    if (inputDescuento == null) {
        println("por favor ingresa un descuento numérico válido.")
        return
    }
    // Utilizamos el set (se valida automáticamente)
    producto.descuento = inputDescuento
    
    print("\n")
    println("resumen del producto:")
    println("precio original: $${producto.precio}")
    println("descuento aplicado: ${producto.descuento}%")
    println("precio final a pagar: $${producto.calcularPrecioFinal()}\n")
}
