# ExamenPMDM

## Variables y Estructura del Juego

El juego se basa en una serie de afirmaciones predefinidas, cada una con una opción de Verdadero o Falso. A continuación, se detallan las características clave del código:

### Frases y Estado del Juego

- **Frases (Frase):** Se definen las afirmaciones con sus textos respectivos y se especifica si son verdaderas o falsas.

- **Variables:**
    - `frases`: Lista que almacena las afirmaciones del juego.
    - `fraseActual`: Representa el estado actual de la afirmación que se está visualizando.
    - `cuentaAtras`: Contador regresivo que indica el tiempo disponible para responder.
    - `puntuacion`: Puntuación acumulada del jugador.
    - `state`: Indica el estado del juego, que puede ser PLAYING o WAITING.

## Interfaz de Usuario (IU)

### Botón "Start" (BotonStart)

Al presionar el botón, se inicia el juego si el estado actual es de espera (State.WAITING). Se reinicia la cuenta atrás y la puntuación, y se inicia una corrutina que gestiona el tiempo.

### Cuenta Atrás (CuentaAtras)

Muestra el tiempo restante para responder las preguntas durante la partida.

### Afirmación Verdadero/Falso (FraseVF)

Muestra la afirmación actual que se debe evaluar como verdadera o falsa.

### Botones Verdadero/Falso (BotonesFalsoVerdadero)

Son dos botones que permiten al jugador seleccionar si la afirmación mostrada es Verdadera o Falsa.

### Puntuación (Puntuacion)

Muestra la puntuación acumulada durante la partida.

### Comprobar Afirmación (ComprobarFrase)

Al hacer clic en los botones de Verdadero o Falso, se verifica si la respuesta es correcta. Se ajusta la puntuación según corresponda y se carga una nueva afirmación para continuar el juego.
