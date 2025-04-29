# Proyecto: Trivial Cultura General

Este proyecto es un juego de preguntas y respuestas de cultura general en el que el jugador puede elegir entre tres categorías: **Deportes, Historia y Ciencia**. El objetivo es responder correctamente a las preguntas para ganar puntos.

| Detalle               | Información       |
|-----------------------|-------------------|
| **Autor**             | Alberto Gálvez    |
| **Fecha de inicio**   | 17/02/2025        |
| **Última revisión**   | 1.4 10/02/2025    |

## Contenido del Proyecto

- **Clase `Main`**: Implementa la lógica principal del juego y la interacción con el jugador.
- **Clase `Pregunta`**: Representa una pregunta, su respuesta, la categoría y el puntaje correspondiente.
- **Clase `Puntuacion`**: Hereda de `Pregunta` y gestiona el puntaje según la categoría.
- **Clase `ArrayBidimensional`**: Contiene un array bidimensional de preguntas y organiza las preguntas por categoría.

## Estructura del Proyecto

```plaintext
Trivial_CulturaGeneral/
    src/
        README.md            # Este archivo
        Main.java            # Lógica principal del juego
        Pregunta.java        # Clase para manejar preguntas
        Puntuacion.java      # Clase que gestiona la puntuación
        ArrayBidimensional.java  # Manejo de preguntas en matriz
```

## Requisitos del Sistema

- **Java Development Kit (JDK)** versión 8 o superior.
- Entorno de desarrollo integrado (IDE) recomendado: IntelliJ IDEA, Eclipse o NetBeans.

## Instrucciones de Ejecución

1. Abre el proyecto en **tu IDE preferido**.
2. Asegúrate de que **JDK 8 o superior** esté correctamente configurado.
3. Ve a la carpeta `src/` y selecciona el archivo `Main.java`.
4. Compila y ejecuta el programa.

## Funcionalidades Principales

- **Categorías de preguntas**: Deportes, Historia y Ciencia.
- **Sistema de puntuación**:
  - Deportes: 15 puntos por respuesta correcta.
  - Historia: 20 puntos por respuesta correcta.
  - Ciencia: 25 puntos por respuesta correcta.
- **Interfaz gráfica básica** con arte ASCII y mensajes interactivos.
- **Validaciones**: Verifica si las respuestas son correctas o incorrectas.
- **Finalización**: El juego termina cuando el jugador elige salir o responde todas las preguntas.

## Notas Adicionales

Este proyecto está diseñado para que los estudiantes aprendan:

- **Programación Orientada a Objetos (POO)** en Java.
- **Modularización**: Organización del código en clases.
- **Interacción en consola y validaciones de entrada**.
- **Manejo de estructuras de datos** en Java.



GIT HUB: https://github.com/algalmo/TRIVIAL.git