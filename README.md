# Verdadero o Falso - MVVM

Este proyecto implementa el juego de Verdadero o Falso utilizando el patrón de arquitectura MVVM (Modelo-Vista-VistaModelo). El juego consiste en mostrar afirmaciones y que el jugador indique si son verdaderas o falsas. El proyecto está desarrollado en Kotlin con Jetpack Compose.

## Contenido del Repositorio

- `IU.kt`: Contiene el código para la interfaz de usuario del juego.
- `Datos.kt`: Define los datos del juego, incluyendo las afirmaciones disponibles.
- `miViewModel.kt`: Implementa el ViewModel (`MiViewModel`) que gestiona los datos y la lógica del juego.
- `README.md`: Este archivo que proporciona una descripción del proyecto.

## Estructura del Código

### Datos.kt

La clase `Datos.kt` define los datos del juego, incluyendo las afirmaciones disponibles representadas por la clase `Frase`.

### miViewModel.kt

El archivo `miViewModel.kt` implementa el ViewModel `MiViewModel`, el cual gestiona los datos y la lógica del juego. Se encarga de iniciar el juego, cargar nuevas afirmaciones, comprobar las respuestas y mantener la cuenta atrás y la puntuación.

### IU.kt

En `IU.kt`, se define la interfaz de usuario del juego utilizando Jetpack Compose. Se implementan componibles para representar los diferentes elementos de la interfaz, como el botón de inicio, la cuenta atrás, la frase actual, los botones de verdadero/falso y la puntuación. Se utiliza el ViewModel para interactuar con los datos y la lógica del juego.

## Uso

Para ejecutar el juego, solo hay que iniciar la aplicación y hacer click en el botón "START" para comenzar. Se mostrará una afirmación y tendrás que indicar si es verdadera o falsa. La cuenta atrás de 20 segundos indica el tiempo disponible para responder cada afirmación.

