package com.dam.examen

// Clase para representar una frase con su texto y veracidad
data class Frase(var texto: String, var verdadero: Boolean)

// Objeto que contiene los datos del juego
object Datos {
    // Lista mutable para almacenar las frases disponibles en el juego
    val frases: MutableList<Frase> = mutableListOf()

    // Inicializa la lista de frases con datos predefinidos
    init {
        cargarFrases()
    }

    // Función para cargar las frases predefinidas en la lista
    private fun cargarFrases() {
        // Agregar frases a la lista utilizando el método apply para una sintaxis más limpia
        frases.apply {
            frases.add(Frase("Rafael Nadal es uno de los mejores deportistas de la historia de españa", true))
            frases.add(Frase("Hoy el barça metió 8 goles", false))
            frases.add(Frase("Mañana es domingo", false))
            frases.add(Frase("uno más uno es dos", true))
            frases.add(Frase("dos mas dos son diez", false))
            frases.add(Frase("las vacas vuelan", false))
            frases.add(Frase("messi es de brazil", false))
            frases.add(Frase("los humanos somos moluscos", true))
            frases.add(Frase("Una semana tiene 7 días", true))
            frases.add(Frase("España es el país más grande de Europa", false))
        }
    }
}
