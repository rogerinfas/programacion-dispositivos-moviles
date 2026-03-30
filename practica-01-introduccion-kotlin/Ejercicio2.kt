import kotlin.random.Random

fun main() {
    println("--- Juego: Piedra, Papel o Tijera ---")
    
    val opciones = arrayOf("Piedra", "Papel", "Tijera")
    
    // aleatorio (0, 1 o 2)
    val eleccionComputadora = Random.nextInt(0, 3)
    
    println("¿Qué opción eliges?")
    println("0) Piedra")
    println("1) Papel")
    println("2) Tijera")
    print("Ingresa tu número (0, 1 o 2): ")
    
    val input = readln()
    val eleccionUsuario = input.toIntOrNull()
    
    // valido entrada
    if (eleccionUsuario == null || eleccionUsuario !in 0..2) {
        println("Debes ingresar 0, 1 o 2")
        return
    }
    print("\n")
    println("Elegiste: ${opciones[eleccionUsuario]}")
    println("Computadora eligió: ${opciones[eleccionComputadora]}\n")
    
    // logica del juegoo
    when {
        eleccionUsuario == eleccionComputadora -> println("Resultado: ¡Empate!")
        (eleccionUsuario == 0 && eleccionComputadora == 2) || // piedra vence tijera
        (eleccionUsuario == 1 && eleccionComputadora == 0) || // papel vence piedra
        (eleccionUsuario == 2 && eleccionComputadora == 1)    // tijera vence papel
        -> println("Res: Ganaste")
        else -> println("Res: Perdiste")
    }
}
