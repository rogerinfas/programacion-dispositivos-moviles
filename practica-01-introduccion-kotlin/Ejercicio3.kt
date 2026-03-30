fun main() {
    var continuar = true

    while (continuar) {
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Elige una opción (1-5): ")

        val input = readln()
        val opcion = input.toIntOrNull()

        if (opcion == null || opcion !in 1..5) {
            println("Opción no válida. Por favor, elige un número del 1 al 5.\n")
            continue
        }

        if (opcion == 5) {
            println("¡Saliendo de la calculadora. Adiós!")
            continuar = false
            continue
        }

        print("Ingresa el primer número: ")
        val num1 = readln().toDoubleOrNull() ?: 0.0

        print("Ingresa el segundo número: ")
        val num2 = readln().toDoubleOrNull() ?: 0.0

        print("Resultado: ")
        when (opcion) {
            1 -> println("${num1} + ${num2} = ${num1 + num2}")
            2 -> println("${num1} - ${num2} = ${num1 - num2}")
            3 -> println("${num1} * ${num2} = ${num1 * num2}")
            4 -> {
                if (num2 == 0.0) {
                    println("Error, no se puede dividir entre cero.")
                } else {
                    println("${num1} / ${num2} = ${num1 / num2}")
                }
            }
        }
        println() // salto de línea para separar las operaciones
    }
}
