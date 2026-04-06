abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String, autor: String, anioPublicacion: Int,
    val genero: String, val numeroPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("libro: '$titulo' de $autor ($anioPublicacion) - género: $genero, páginas: $numeroPaginas")
    }
}

class Revista(
    titulo: String, autor: String, anioPublicacion: Int,
    val issn: String, val volumen: Int, val numero: Int, val editorial: String
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("revista: '$titulo' vol. $volumen no. $numero ($anioPublicacion) - editorial: $editorial, issn: $issn")
    }
}

data class Usuario(val nombre: String, val apellido: String, val edad: Int)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestamo(usuario: Usuario, material: Material)
    fun devolucion(usuario: Usuario, material: Material)
    fun mostrarMaterialesDisponibles()
    fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()
    private val usuarios = mutableListOf<Usuario>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("material registrado: ${material.titulo}")
    }

    override fun registrarUsuario(usuario: Usuario) {
        if (!usuarios.contains(usuario)) {
            usuarios.add(usuario)
            prestamos[usuario] = mutableListOf()
            println("usuario registrado: ${usuario.nombre} ${usuario.apellido}")
        }
    }

    override fun prestamo(usuario: Usuario, material: Material) {
        if (!usuarios.contains(usuario)) {
            println("error: el usuario ${usuario.nombre} no está registrado en la biblioteca.")
            return
        }
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("préstamo exitoso: '${material.titulo}' prestado a ${usuario.nombre}.")
        } else {
            println("error: el material '${material.titulo}' no está disponible.")
        }
    }

    override fun devolucion(usuario: Usuario, material: Material) {
        val materialesUsuario = prestamos[usuario]
        if (materialesUsuario != null && materialesUsuario.contains(material)) {
            materialesUsuario.remove(material)
            materialesDisponibles.add(material)
            println("devolución exitosa: '${material.titulo}' devuelto por ${usuario.nombre}.")
        } else {
            println("error: el usuario ${usuario.nombre} no tiene prestado '${material.titulo}'.")
        }
    }

    override fun mostrarMaterialesDisponibles() {
        println("\n--- materiales disponibles ---")
        if (materialesDisponibles.isEmpty()) {
            println("no hay materiales disponibles.")
        } else {
            for (m in materialesDisponibles) {
                m.mostrarDetalles()
            }
        }
        println("------------------------------\n")
    }

    override fun mostrarMaterialesReservadosPorUsuario(usuario: Usuario) {
        println("\n--- préstamos de ${usuario.nombre} ${usuario.apellido} ---")
        val materiales = prestamos[usuario]
        if (materiales.isNullOrEmpty()) {
            println("el usuario no tiene materiales en préstamo.")
        } else {
            for (m in materiales) {
                m.mostrarDetalles()
            }
        }
        println("------------------------------\n")
    }
}

fun main() {
    println("ejercicio 3: sistema de gestión de biblioteca\n")

    val biblioteca = Biblioteca()

    val libro1 = Libro("Jorge, el hijo del pueblo", "María Nieves y Bustamante", 1892, "Novela Histórica", 538)
    val revista1 = Revista("Tradiciones Arequipeñas", "Varios Autores", 1990, "1234-5678", 5, 2, "Universidad Nacional de San Agustín (UNSA)")

    val usuario1 = Usuario("Josué", "Flores", 25)

    // Simulando el ciclo de vida del sistema
    biblioteca.registrarMaterial(libro1)
    biblioteca.registrarMaterial(revista1)
    biblioteca.registrarUsuario(usuario1)

    biblioteca.mostrarMaterialesDisponibles()

    // Realizar un préstamo
    biblioteca.prestamo(usuario1, libro1)

    // Mostrar el inventario y reservas tras el préstamo
    biblioteca.mostrarMaterialesDisponibles()
    biblioteca.mostrarMaterialesReservadosPorUsuario(usuario1)

    // Realizar la devolución
    biblioteca.devolucion(usuario1, libro1)

    // Inventario tras la devolución
    biblioteca.mostrarMaterialesDisponibles()
}
