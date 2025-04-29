package clases;

import java.util.*;

/**
 * Clase que representa una colección de preguntas organizadas por categoría.
 */
public class ArrayBidimensional {
    private final Map<Categoria, List<Pregunta>> preguntasPorCategoria;

    public ArrayBidimensional() {
        preguntasPorCategoria = new HashMap<>();
        inicializarPreguntas();
    }

    private void inicializarPreguntas() {
        Categoria deportes = new Categoria("Deportes", "Preguntas relacionadas con deportes", 15);
        Categoria historia = new Categoria("Historia", "Preguntas relacionadas con historia", 20);
        Categoria ciencia = new Categoria("Ciencia", "Preguntas relacionadas con ciencia", 25);

        preguntasPorCategoria.put(deportes, List.of(
            new Pregunta("¿Cuál es el deporte más popular del mundo?", "Fútbol", deportes),
            new Pregunta("¿Cuántos jugadores tiene un equipo de fútbol?", "11", deportes),
            new Pregunta("¿En qué deporte se usa una raqueta?", "Tenis", deportes),
            new Pregunta("¿Qué deporte se juega en Wimbledon?", "Tenis", deportes),
            new Pregunta("¿Qué deporte se juega en el Super Bowl?", "Fútbol americano", deportes),
            new Pregunta("¿Qué deporte se juega en la NBA?", "Baloncesto", deportes),
            new Pregunta("¿Qué deporte se juega en el Tour de Francia?", "Ciclismo", deportes),
            new Pregunta("¿Qué deporte se juega en el Abierto de Australia?", "Tenis", deportes),
            new Pregunta("¿Qué deporte se juega en el Mundial?", "Fútbol", deportes),
            new Pregunta("¿Qué deporte se juega en la Serie Mundial?", "Béisbol", deportes)
        ));

        preguntasPorCategoria.put(historia, List.of(
            new Pregunta("¿En qué año comenzó la Segunda Guerra Mundial?", "1939", historia),
            new Pregunta("¿Quién fue el primer presidente de los Estados Unidos?", "Washington", historia),
            new Pregunta("¿En qué año llegó el hombre a la luna?", "1969", historia),
            new Pregunta("¿Quién descubrió América?", "Colón", historia),
            new Pregunta("¿Quién fue el primer emperador de Roma?", "Augusto", historia),
            new Pregunta("¿En qué año cayó el Muro de Berlín?", "1989", historia),
            new Pregunta("¿Quién fue el primer ministro de India?", "Nehru", historia),
            new Pregunta("¿Quién fue el primer presidente de Sudáfrica?", "Mandela", historia),
            new Pregunta("¿Quién fue el primer presidente de México?", "Victoria", historia),
            new Pregunta("¿Quién fue el primer presidente de Francia?", "Napoleón", historia)
        ));

        preguntasPorCategoria.put(ciencia, List.of(
            new Pregunta("¿Cuál es el elemento químico más abundante en el universo?", "Hidrógeno", ciencia),
            new Pregunta("¿Cuál es la fórmula química del agua?", "H2O", ciencia),
            new Pregunta("¿Cuál es el planeta más grande del sistema solar?", "Júpiter", ciencia),
            new Pregunta("¿Cuál es la velocidad de la luz?", "299792458", ciencia),
            new Pregunta("¿Cuál es el animal más grande del mundo?", "Ballena azul", ciencia),
            new Pregunta("¿Cuál es el metal más ligero?", "Litio", ciencia),
            new Pregunta("¿Cuál es el gas más abundante en la atmósfera?", "Nitrógeno", ciencia),
            new Pregunta("¿Cuál es el órgano más grande del cuerpo humano?", "Piel", ciencia),
            new Pregunta("¿Cuál es el hueso más largo del cuerpo humano?", "Fémur", ciencia),
            new Pregunta("¿Cuál es el planeta más cercano al sol?", "Mercurio", ciencia)
        ));
    }

    /**
     * Obtiene una lista de preguntas para una categoría dada.
     * @param categoria la categoría deseada.
     * @return una lista de preguntas, o una lista vacía si no hay preguntas.
     */
    public List<Pregunta> obtenerPreguntasDeCategoria(Categoria categoria) {
        for (Categoria cat : preguntasPorCategoria.keySet()) {
            if (cat.getNombre().equalsIgnoreCase(categoria.getNombre())) {
                return preguntasPorCategoria.get(cat);
            }
        }
        return Collections.emptyList();
    }
}



