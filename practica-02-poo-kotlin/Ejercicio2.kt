abstract class Shape {
    var area: Double = 0.0
    var perimetro: Double = 0.0

    abstract fun calcularArea()
    abstract fun calcularPerimetro()

    fun imprimirResultados(nombreFigura: String) {
        // Todo en minúsculas para mantener el estilo de tu código
        println("resultados para $nombreFigura:")
        println("área: $area")
        println("perímetro: $perimetro\n")
    }
}

class Cuadrado : Shape {
    var lado: Double = 0.0

    // Uso de constructor secundario ("con constructores secundarios")
    constructor(lado: Double) : super() {
        this.lado = lado
        // Al instanciar, calculamos de inmediato sus valores
        calcularArea()
        calcularPerimetro()
    }

    override fun calcularArea() {
        area = lado * lado
    }

    override fun calcularPerimetro() {
        perimetro = 4 * lado
    }
}

class Circulo : Shape {
    var radio: Double = 0.0

    // Uso de constructor secundario recibiendo el radio
    constructor(radio: Double) : super() {
        this.radio = radio
        calcularArea()
        calcularPerimetro()
    }

    override fun calcularArea() {
        val pi = 3.14
        area = pi * radio * radio
    }

    override fun calcularPerimetro() {
        val pi = 3.14
        perimetro = 2 * pi * radio
    }
}

class Rectangulo : Shape {
    var base: Double = 0.0
    var altura: Double = 0.0

    // Uso de constructor secundario recibiendo lados
    constructor(base: Double, altura: Double) : super() {
        this.base = base
        this.altura = altura
        calcularArea()
        calcularPerimetro()
    }

    override fun calcularArea() {
        area = base * altura
    }

    override fun calcularPerimetro() {
        perimetro = 2 * (base + altura)
    }
}

fun main() {
    println("ejercicio 2: figuras geométricas\n")

    val miCuadrado = Cuadrado(4.0)
    miCuadrado.imprimirResultados("cuadrado")

    val miCirculo = Circulo(3.0)
    miCirculo.imprimirResultados("círculo")

    val miRectangulo = Rectangulo(5.0, 2.0)
    miRectangulo.imprimirResultados("rectángulo")
}
