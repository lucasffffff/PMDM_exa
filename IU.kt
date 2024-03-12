package com.dam.examen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun IU(viewModel: MiViewModel) {
    val iuScope = rememberCoroutineScope()

    // Utilizamos LaunchedEffect para iniciar el juego cuando la IU es mostrada
    LaunchedEffect(Unit) {
        viewModel.iniciarJuego(iuScope)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BotonIniciar(viewModel, iuScope)
        Spacer(modifier = Modifier.height(16.dp))
        CuentaAtras(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        FraseVF(viewModel)
        Spacer(modifier = Modifier.height(16.dp))
        Puntuacion(viewModel)
    }
}

@Composable
fun BotonIniciar(viewModel: MiViewModel, iuScope: CoroutineScope) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .padding(0.dp, 20.dp, 0.dp, 50.dp)
    ) {
        Button(
            onClick = {
                viewModel.iniciarJuego(iuScope)
            }
        ) {
            Text(text = "Iniciar")
        }
    }
}

@Composable
fun CuentaAtras(viewModel: MiViewModel) {
    Text(
        text = "Cuenta atrás:",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = viewModel.cuentaAtras.toString(),
        fontSize = 50.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun FraseVF(viewModel: MiViewModel) {
    Frase(viewModel)
    Spacer(modifier = Modifier.height(16.dp))
    BotonesFalsoVerdadero(viewModel)
}

@Composable
fun Frase(viewModel: MiViewModel) {
    Text(
        text = viewModel.fraseActual.texto,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BotonesFalsoVerdadero(viewModel: MiViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        BotonFV(true, viewModel)
        Spacer(modifier = Modifier.width(16.dp))
        BotonFV(false, viewModel)
    }
}

@Composable
fun BotonFV(respuesta: Boolean, viewModel: MiViewModel) {
    Button(
        onClick = {
            viewModel.comprobarRespuesta(respuesta)
        },
        modifier = Modifier
            .padding(end = 10.dp)
    ) {
        Text(text = if (respuesta) "Verdadero" else "Falso")
    }
}

@Composable
fun Puntuacion(viewModel: MiViewModel) {
    Text(
        text = "Puntuación: ${viewModel.puntuacion}",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}
