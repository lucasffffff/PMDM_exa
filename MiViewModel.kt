package com.dam.examen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class MiViewModel : ViewModel() {
    // Estado de la frase actual mostrada en la interfaz de usuario
    private val _fraseActual: MutableState<Frase> = mutableStateOf(Frase("-", true))
    val fraseActual: MutableState<Frase> = _fraseActual

    // Estado de la cuenta atrás
    private val _cuentaAtras: MutableState<Int> = mutableStateOf(20)
    val cuentaAtras: MutableState<Int> = _cuentaAtras

    // Estado de la puntuación del jugador
    private val _puntuacion: MutableState<Int> = mutableStateOf(0)
    val puntuacion: MutableState<Int> = _puntuacion

    // Estado del juego (jugando o esperando)
    private val _state: MutableState<State> = mutableStateOf(State.WAITING)
    val state: MutableState<State> = _state

    // Alcance de la corrutina
    private val viewModelScope = CoroutineScope(Dispatchers.Default)

    // Inicialización: carga una nueva frase al inicio
    init {
        cargarNuevaFrase()
    }

    // Función para iniciar el juego
    fun iniciarJuego() {
        if (state.value == State.WAITING) {
            cuentaAtras.value = 20
            puntuacion.value = 0
            // Corrutina para gestionar la cuenta atrás
            viewModelScope.launch {
                state.value = State.PLAYING
                while (cuentaAtras.value > 0) {
                    delay(1000)
                    cuentaAtras.value -= 1
                }
                state.value = State.WAITING
            }
            cargarNuevaFrase()
        }
    }

    // Función para cargar una nueva frase
    private fun cargarNuevaFrase() {
        fraseActual.value = Datos.frases.random()
    }

    // Función para comprobar la respuesta del jugador
    fun comprobarRespuesta(respuesta: Boolean) {
        if (state.value == State.PLAYING) {
            if (respuesta == fraseActual.value.verdadero) {
                puntuacion.value += 10
            } else {
                puntuacion.value -= 5
                if (puntuacion.value < 0) {
                    puntuacion.value = 0
                }
            }
            cargarNuevaFrase()
        }
    }
}

// Enum para representar el estado del juego
enum class State {
    PLAYING, // Jugando
    WAITING // Esperando
}
