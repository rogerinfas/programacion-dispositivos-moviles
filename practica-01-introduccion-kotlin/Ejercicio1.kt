fun main() {
    println("--- Evaluación empleados ---")

    print("Ingrese salario mensual: ")
    val salario = readln().toDouble()

    print("Ingrese la puntuación 0 a 10: ")
    val puntuacion = readln().toInt()

    val nivel = when (puntuacion) {
        in 0..3 -> "inaceptable"
        in 4..6 -> "aceptable"
        in 7..10 -> "meritorio"
        else -> {
            println("Puntuación invalida, debe ser un número entero entre 0 y 10.")
            return
        }
    }

    val dineroRecibido = salario * (puntuacion / 10.0)

    // Imprimimos el resultado con el formato que mencionaste.
    println("Resultados: Nivel de Rendimiento $nivel, cantidad de dinero recibido $${dineroRecibido}")
}
