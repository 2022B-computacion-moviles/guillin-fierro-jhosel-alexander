import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
    // Tipos de variables

    // Inmutables: Variables que no se pueden reasignar, no se puede utilizar el = para cambiar su contenido
    val inmutable: String = "String";
    // inmutable = "Adrian";

    // Mutables (re asignar) =
    var mutable: String = "Alexander";
    mutable = "Jhosel";

    // val > var

    // Duck Typing
    val ejemploVariable = "Ejemplo"
    ejemploVariable.trim()
    val edadEjemplo: Int = 12

    // Variables primitivas
    val nombreProfesor: String = "Jhosel Guillin"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    val mayorEdad: Boolean = true
    val fechaNacimiento: Date = Date() // no se usa "new" en clases

    /*if(true){

    }else{

    }*/

    // Switch no existe
    val estadoCivilWhen = "S"
    when(estadoCivilWhen){
        ("S")->{
            println("Soltero")
        }
        "C"-> println("Casado")
        else -> println("Desconocido")
    }
    val coqueto = if(estadoCivilWhen == "S") "Si" else "No"

    val sumaUno = Suma(1,2)
    val sumaDos = Suma(1, null)
    val sumaTres = Suma(null, 2)
    val sumaCuatro = Suma(null, null)
    sumaUno.sumar()
    sumaDos.sumar()
    sumaTres.sumar()
    sumaCuatro.sumar()
    println(Suma.historialSumas)

}

fun imprimirNombre(nombre: String): Unit{ // Unit --> void
    println("Nombre: ${nombre}")
}
fun calcularSueldo(
    sueldo: Double, // requerido
    tasa: Double = 12.00, // opcional por defecto
    bonoEspecial: Double? = null // opcional nulo ?
):Double{
    // String -> String?
    // Int -> Int
    // Date -> Date?

    if(bonoEspecial != null){
        return sueldo * tasa * bonoEspecial
    }
    return sueldo * tasa
}

abstract class NumerosJava{
    protected  val numeroUno: Int
    private val numeroDos: Int
    constructor(
        uno: Int, //parametro
        dos: Int //parametro
    ){
        this.numeroUno = uno;
        this.numeroDos = dos;
        println("Iniciando")
    }
}

//Kotlin
abstract class Numeros( // Constructor Primario
    // uno: Int, // Parametro
    // public var uno: Int, // propiedad de la clase publica
    protected  val numeroUno: Int, // propiedad
    protected val numeroDos: Int // propiedad
){
    init { // Bloque codigo constructor primario
        // this.numeroDos // "this" opcional
        // this.numeroUno
        numeroUno
        numeroDos
        println("Iniciando")
    }
}

//Herencia
class Suma( // Constructor Primario Suma
    uno: Int, // Parametro
    dos: Int // Parametro
): Numeros( // Heredamos de la clase Numeros
    // Super constructor numeros
    uno,
    dos
){
    init { // Bloque constructor primario
        this.numeroUno
        this.numeroDos
    }

    constructor( // Segundo constructor
        uno: Int?, //Parametro
        dos: Int //Parametro
    ): this(
        if(uno == null) 0 else uno,
        dos
    ){}

    constructor( // Tercer constructor
        uno: Int, //Parametro
        dos: Int? //Parametro
    ): this(
        uno,
        if(dos == null) 0 else dos,
    ){}

    constructor( // Cuarto constructor
        uno: Int?, //Parametro
        dos: Int? //Parametro
    ): this(
        if(uno == null) 0 else uno,
        if(dos == null) 0 else dos,
    ){}

    fun sumar(): Int{
        val total = numeroUno + numeroDos
        agregarHistorial(total)
        return total
    }

    companion object{
        val pi = 3.14 // Suma.pi -> 3.14
        val historialSumas = arrayListOf<Int>() //Suma.hitorialSumas

        fun agregarHistorial(valorNuevaSuma: Int){ //Suma.agregarHistorial
            historialSumas.add(valorNuevaSuma)
        }
    }
}