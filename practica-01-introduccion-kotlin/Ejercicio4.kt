import kotlin.random.Random

fun main() {
    println("adivina el nusmero (del 1 al 30)")
    
    val numeroSecreto = Random.nextInt(1, 31) // de 1 a 30 inclusive
    var intentosRestantes = 5
    var adivinado = false
    
    println("he pensado un número entre 1 y 30. Tienes 5 intentos para adivinarlo.\n")
    
    while (intentosRestantes > 0) {
        println("intentos restantes: $intentosRestantes")
        print("ingresa tu número: ")
        
        val input = readln().toIntOrNull()
        
        if (input == null || input !in 1..30) {1
            println("por favor ingresa un número válido entre 1 y 30.\n")
            continue
        }
        
        if (input == numeroSecreto) {
            println("Felicidades! Adivinaste el número $numeroSecreto y ganaste el juego.")
            adivinado = true
            break
        } else if (input < numeroSecreto) {
            println("pista: El número secreto es MAYOR que $input.\n")
        } else {
            println("pista: El número secreto es MENOR que $input.\n")
        }
        
        intentosRestantes--
    }
    
    if (!adivinado) {
        println("game over! Te quedaste sin intentos. El número secreto era $numeroSecreto.")
    }
}
