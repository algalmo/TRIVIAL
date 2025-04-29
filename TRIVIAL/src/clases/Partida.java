package clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una partida de juego.
 */
public class Partida {
    private final String nombreJugador;
    private final LocalDateTime fechaHora; // Combina fecha y hora en un solo atributo.
    private int puntos;
    private final List<PreguntaRespondida> preguntasRespondidas; // Lista de preguntas respondidas

    /**
     * Constructor para inicializar una partida.
     * 
     * @param nombreJugador Nombre del jugador.
     * @param fechaHora Fecha y hora de la partida.
     */
    public Partida(String nombreJugador, LocalDateTime fechaHora) {
        this.nombreJugador = nombreJugador;
        this.fechaHora = fechaHora;
        this.puntos = 0;
        this.preguntasRespondidas = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombreJugador() {
        return nombreJugador;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public List<PreguntaRespondida> getPreguntasRespondidas() {
        return preguntasRespondidas;
    }

    /**
     * Agrega una pregunta respondida a la lista.
     * 
     * @param pregunta La pregunta respondida.
     * @param esCorrecta Indica si la respuesta fue correcta.
     */
    public void agregarPreguntaRespondida(Pregunta pregunta, boolean esCorrecta) {
        preguntasRespondidas.add(new PreguntaRespondida(pregunta, esCorrecta));
    }

    @Override
    public String toString() {
        // Formatear la fecha y hora para mostrarla de forma legible
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return "Partida de " + nombreJugador + " | Fecha y hora: " + fechaHora.format(formatter) + " | Puntos: " + puntos;
    }

    /**
     * Clase interna para representar una pregunta respondida.
     */
    public static class PreguntaRespondida {
        private final Pregunta pregunta;
        private final boolean esCorrecta;

        public PreguntaRespondida(Pregunta pregunta, boolean esCorrecta) {
            this.pregunta = pregunta;
            this.esCorrecta = esCorrecta;
        }

        public Pregunta getPregunta() {
            return pregunta;
        }

        public boolean isEsCorrecta() {
            return esCorrecta;
        }

        @Override
        public String toString() {
            return "Pregunta: " + pregunta.getPregunta() + " | Respuesta correcta: " + esCorrecta;
        }
    }

public void guardarEnFichero(String nombreFichero) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero, true))) {
        writer.write(this.toString());
        writer.newLine();
        for (PreguntaRespondida pr : preguntasRespondidas) {
            writer.write("   " + pr.toString());
            writer.newLine();
        }
        writer.newLine();
    } catch (IOException e) {
        System.err.println("Error al guardar la partida: " + e.getMessage());
    }
}

}