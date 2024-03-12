package com.dam.examen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Frase(var texto: String, var verdadero: Boolean)

var frases: MutableList<Frase> = mutableListOf()
var fraseActual: MutableState<Frase> = mutableStateOf(Frase("-", true))
var cuentaAtras: MutableState<Int> = mutableStateOf(20)
var puntuacion: MutableState<Int> = mutableStateOf(0)
var state: State = State.WAITING

enum class State {
    PLAYING, WAITING
}

fun cargarFrases() {
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

    fraseActual.value = frases.random()
}

@Composable
fun UserInterface() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BotonStart()
        Spacer(modifier = Modifier.height(16.dp))
        CuentaAtras()
        Spacer(modifier = Modifier.height(16.dp))
        FraseVF()
        Spacer(modifier = Modifier.height(16.dp))
        Puntuacion()
    }
}
@Composable
fun BotonStart() {
    val iuScope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .padding(0.dp, 20.dp, 0.dp, 50.dp)
    ) {
        Button(
            onClick = {
                if (state == State.WAITING) {
                    cuentaAtras.value = 20
                    puntuacion.value = 0
                    iuScope.launch {
                        state = State.PLAYING
                        while (cuentaAtras.value > 0) {
                            delay(1000)
                            cuentaAtras.value -= 1
                        }
                        state = State.WAITING
                    }
                    cargarFrases()
                }
            }
        ) {
            Text(text = "Start")
        }
    }
}

@Composable
fun CuentaAtras() {
    Text(
        text = "Cuenta atras:",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = cuentaAtras.value.toString(),
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun FraseVF() {
    Frase()
    Spacer(modifier = Modifier.height(16.dp))
    BotonesFalsoVerdadero()
}

@Composable
fun Frase() {
    Text(
        text = fraseActual.value.texto,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}
@Composable
fun BotonesFalsoVerdadero() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BotonFV(true)
        Spacer(modifier = Modifier.width(16.dp)) // Añade un espacio entre los elementos
        BotonFV(false)
    }
}

@Composable
fun BotonFV(respuesta: Boolean) {
    Button(
        onClick = {
            if (state == State.PLAYING) {
                ComprobarFrase(respuesta)
            }
        },
        modifier = Modifier
            .padding(end = 10.dp)
    ) {
        Text(text = if (respuesta) "Verdadero" else "Falso")
    }
}

@Composable
fun Puntuacion() {
    Text(
        text = "Puntuación: ${puntuacion.value}",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}

fun ComprobarFrase(respuesta: Boolean) {
    if (respuesta == fraseActual.value.verdadero) {
        puntuacion.value += 10
    } else {
        puntuacion.value -= 5
        if (puntuacion.value < 0) {
            puntuacion.value = 0
        }
    }
    cargarFrases()
}
