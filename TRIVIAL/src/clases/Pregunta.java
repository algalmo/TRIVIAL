package clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una pregunta con su respuesta y categoría.
 */
public class Pregunta {
    private String pregunta;
    private List<String> respuestasCorrectas; // Lista de respuestas correctas
    private Categoria categoria;

    /**
     * Constructor para inicializar una pregunta con una única respuesta correcta.
     * 
     * @param pregunta El enunciado de la pregunta.
     * @param respuesta La respuesta correcta de la pregunta.
     * @param categoria La categoría de la pregunta.
     */
    public Pregunta(String pregunta, String respuesta, Categoria categoria) {
        this.pregunta = pregunta;
        this.respuestasCorrectas = new ArrayList<>();
        this.respuestasCorrectas.add(respuesta); // Agregar la respuesta inicial
        this.categoria = categoria;
    }

    /**
     * Constructor para inicializar una pregunta con múltiples respuestas correctas.
     * 
     * @param pregunta El enunciado de la pregunta.
     * @param respuestas Lista de respuestas correctas.
     * @param categoria La categoría de la pregunta.
     */
    public Pregunta(String pregunta, List<String> respuestas, Categoria categoria) {
        this.pregunta = pregunta;
        this.respuestasCorrectas = new ArrayList<>(respuestas); // Copiar las respuestas
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getPregunta() {
        return pregunta;
    }

    public List<String> getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setPregunta(String enunciado) {
        this.pregunta = enunciado;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Agrega una respuesta correcta adicional.
     * 
     * @param respuesta La respuesta correcta a agregar.
     */
    public void agregarRespuestaCorrecta(String respuesta) {
        if (!respuestasCorrectas.contains(respuesta)) {
            respuestasCorrectas.add(respuesta);
        }
    }

    /**
     * Verifica si una respuesta dada es correcta.
     * 
     * @param respuesta La respuesta a verificar.
     * @return true si la respuesta es correcta, false en caso contrario.
     */
    public boolean esRespuestaCorrecta(String respuesta) {
        return respuestasCorrectas.stream()
                .map(String::toLowerCase)
                .anyMatch(r -> r.equals(respuesta.toLowerCase()));
    }

    @Override
    public String toString() {
        return categoria.getNombre() + ": " + pregunta + " (Respuestas correctas: " + respuestasCorrectas + ", Puntos: " + categoria.getPuntos() + ")";
    }
}