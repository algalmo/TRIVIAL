/*
 * @version 1.5
 * @author AGM
 * 16/02/2025
 */

import clases.ArrayBidimensional;
import clases.Categoria;
import clases.Partida;
import clases.Pregunta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
public class Main {

    // Colores para el texto
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AZUL = "\u001B[34m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String BLANCO = "\u001B[37m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String FONDO_BLANCO = "\033[47m";

    // Constantes para las opciones del menú
    private static final String OPCION_DEPORTES = "1";
    private static final String OPCION_HISTORIA = "2";
    private static final String OPCION_CIENCIA = "3";
    private static final String OPCION_SALIR = "4";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mostrarArte();
        String nombre = pedirNombre(sc);

        // Crear objeto Partida con la fecha y hora actuales
        Partida partida = new Partida(nombre, LocalDateTime.now());

        // Crear el banco de preguntas
        ArrayBidimensional arrayBidemensional = new ArrayBidimensional();

        // Mostrar el menú
        mostrarMenu(sc, arrayBidemensional, partida);

        // Exportar la partida al salir
        partida.guardarEnFichero("historial_partidas.txt");


        sc.close();
    }

    private static void mostrarArte() {
        System.out.println(CYAN_BOLD + FONDO_BLANCO);
        System.out.println("\r\n" +
                "──────────────────────────────────────────────────────────────────────────────────────────────────────\r\n"
                +
                "─██████████████─████████████████───██████████─██████──██████─██████████─██████████████─██████─────────\r\n"
                +
                "─██░░░░░░░░░░██─██░░░░░░░░░░░░██───██░░░░░░██─██░░██──██░░██─██░░░░░░██─██░░░░░░░░░░██─██░░██─────────\r\n"
                +
                "─██████░░██████─██░░████████░░██───████░░████─██░░██──██░░██─████░░████─██░░██████░░██─██░░██─────────\r\n"
                +
                "─────██░░██─────██░░██────██░░██─────██░░██───██░░██──██░░██───██░░██───██░░██──██░░██─██░░██─────────\r\n"
                +
                "─────██░░██─────██░░████████░░██─────██░░██───██░░██──██░░██───██░░██───██░░██████░░██─██░░██─────────\r\n"
                +
                "─────██░░██─────██░░░░░░░░░░░░██─────██░░██───██░░██──██░░██───██░░██───██░░░░░░░░░░██─██░░██─────────\r\n"
                +
                "─────██░░██─────██░░██████░░████─────██░░██───██░░██──██░░██───██░░██───██░░██████░░██─██░░██─────────\r\n"
                +
                "─────██░░██─────██░░██──██░░██───────██░░██───██░░░░██░░░░██───██░░██───██░░██──██░░██─██░░██─────────\r\n"
                +
                "─────██░░██─────██░░██──██░░██████─████░░████─████░░░░░░████─████░░████─██░░██──██░░██─██░░██████████─\r\n"
                +
                "─────██░░██─────██░░██──██░░░░░░██─██░░░░░░██───████░░████───██░░░░░░██─██░░██──██░░██─██░░░░░░░░░░██─\r\n"
                +
                "─────██████─────██████──██████████─██████████─────██████─────██████████─██████──██████─██████████████─\r\n"
                +
                "──────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println(RESET);
    }

    private static String pedirNombre(Scanner scanner) {
        String nombre;
        System.out.println(AMARILLO + "Bienvenido al Trivial de Cultura General." + RESET);
        System.out.println(CYAN_BOLD + "Introduce tu nombre para comenzar: " + RESET);

        do {
            System.out.print(AMARILLO + "Nombre: " + RESET);
            nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) {
                System.out.println(ROJO + "El nombre no puede estar vacío. Inténtalo de nuevo." + RESET);
            }
        } while (nombre.isEmpty());

        return nombre;
    }

    private static void mostrarMenu(Scanner scanner, ArrayBidimensional arrayBidemensional, Partida partida) {
        String opcion;
        do {
            imprimirMenu();
            opcion = scanner.nextLine().trim();
            procesarOpcionMenu(opcion, scanner, arrayBidemensional, partida);
        } while (!opcion.equals(OPCION_SALIR));

        partida.guardarEnFichero("historial_partidas.txt");

        System.out.println(VERDE + "Gracias por jugar. ¡Hasta la próxima!" + RESET);
    }

    private static void imprimirMenu() {
        System.out.println(AMARILLO + "\nElige una categoría:" + RESET);
        System.out.println("1. " + CYAN_BOLD + "DEPORTES" + RESET);
        System.out.println("2. " + CYAN_BOLD + "HISTORIA" + RESET);
        System.out.println("3. " + CYAN_BOLD + "CIENCIA" + RESET);
        System.out.println("4. " + ROJO + "SALIR" + RESET);
        System.out.println("5. " + AZUL + "VER HISTORIAL DE PARTIDAS" + RESET); // Nueva opción
        System.out.print(AMARILLO + "Opción: " + RESET);
    }

    private static void procesarOpcionMenu(String opcion, Scanner scanner, ArrayBidimensional arrayBidemensional,
    Partida partida) {
    switch (opcion) {
    case OPCION_DEPORTES:
        mostrarPreguntasCategoria(scanner, arrayBidemensional, "Deportes", partida);
        break;
    case OPCION_HISTORIA:
        mostrarPreguntasCategoria(scanner, arrayBidemensional, "Historia", partida);
        break;
    case OPCION_CIENCIA:
        mostrarPreguntasCategoria(scanner, arrayBidemensional, "Ciencia", partida);
        break;
    case "5": // Nueva opción para mostrar el historial de partidas
        mostrarHistorial("historial_partidas.txt");
        break;
    case OPCION_SALIR:
        partida.guardarEnFichero("historial_partidas.txt");
        break;
    default:
        System.out.println(ROJO + "Opción no válida. Inténtalo de nuevo." + RESET);
}
}
    private static void mostrarPreguntasCategoria(Scanner scanner, ArrayBidimensional arrayBidemensional,
            String nombreCategoria, Partida partida) {
        List<Pregunta> preguntasDeCategoria = arrayBidemensional
                .obtenerPreguntasDeCategoria(new Categoria(nombreCategoria, "", 0));

        if (preguntasDeCategoria.isEmpty()) {
            System.out.println(ROJO + "No hay preguntas disponibles en esta categoría." + RESET);
        } else {
            for (Pregunta pregunta : preguntasDeCategoria) {
                System.out.println("\n" + BLANCO + "Categoría: " + pregunta.getCategoria().getNombre() + RESET);
                System.out.println(AZUL + "Pregunta: " + pregunta.getPregunta() + RESET);
                System.out.print(CYAN_BOLD + "Tu respuesta: " + RESET);
                String respuestaUsuario = scanner.nextLine().trim();
                verificarRespuesta(pregunta, respuestaUsuario, partida);
                System.out.println(AMARILLO + "Puntos acumulados: " + partida.getPuntos() + RESET);
            }
        }
    }

    
    private static void verificarRespuesta(Pregunta pregunta, String respuestaUsuario, Partida partida) {
        // Normalizar las cadenas para eliminar tildes y convertir a minúsculas
        String respuestaUsuarioNormalizada = normalizarCadena(respuestaUsuario);
        String respuestaCorrectaNormalizada = normalizarCadena(pregunta.getRespuestasCorrectas().get(0)); // Suponiendo una única respuesta correcta

        boolean esCorrecta = respuestaUsuarioNormalizada.equals(respuestaCorrectaNormalizada);

        if (esCorrecta) {
            System.out.println(VERDE + "¡Correcto!" + RESET);
            partida.setPuntos(partida.getPuntos() + pregunta.getCategoria().getPuntos());
        } else {
            System.out.println(ROJO + "Incorrecto. Las respuestas correctas son: " + pregunta.getRespuestasCorrectas() + RESET);

            // Restar puntos dependiendo de la categoría
            String nombreCategoria = pregunta.getCategoria().getNombre().toLowerCase();
            int puntosARestar = 0;

            switch (nombreCategoria) {
                case "deportes":
                    puntosARestar = 10;
                    break;
                case "historia":
                    puntosARestar = 15;
                    break;
                case "ciencia":
                    puntosARestar = 20;
                    break;
                default:
                    System.out.println(ROJO + "Categoría desconocida. No se restarán puntos." + RESET);
            }

            partida.setPuntos(partida.getPuntos() - puntosARestar);
            System.out.println(ROJO + "Has perdido " + puntosARestar + " puntos." + RESET);
        }

        // Registrar la pregunta respondida
        partida.agregarPreguntaRespondida(pregunta, esCorrecta);
    }

    /**
     * Normaliza una cadena eliminando tildes y convirtiéndola a minúsculas.
     *
     * @param cadena La cadena a normalizar.
     * @return La cadena normalizada.
     */
    private static String normalizarCadena(String cadena) {
        if (cadena == null) {
            return "";
        }
        // Eliminar tildes y convertir a minúsculas
        return Normalizer.normalize(cadena, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "") // Elimina los diacríticos (tildes)
                .toLowerCase();
    }

    public static void mostrarHistorial(String nombreFichero) {
        File archivo = new File(nombreFichero);
        if (!archivo.exists()) {
            System.out.println("Todavía no hay partidas guardadas.");
            return;
        }
    
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("No se pudo leer el historial: " + e.getMessage());
        }
    }
    

    public static void exportarPartidas(List<Partida> partidas) {
    if (partidas.isEmpty()) {
        System.out.println("No hay partidas para exportar.");
    } else {
        try {
            // Comprobar y crear la carpeta "files" si no existe
            File carpeta = new File("files");
            if (!carpeta.exists()) {
                carpeta.mkdirs(); // Crea la carpeta si no existe
                System.out.println("Carpeta 'files' creada.");
            }

            // Abrir el fichero "partidas.txt" en modo append
            FileWriter fileWriter = new FileWriter("files/partidas.txt", true);
            PrintWriter writer = new PrintWriter(fileWriter);

            // Escribir los datos de cada partida
            for (Partida partida : partidas) {
                // Calcular la duración de la partida
                LocalDateTime inicio = partida.getFechaHora();
                LocalDateTime fin = LocalDateTime.now(); // Suponiendo que el fin es ahora
                Duration duracion = Duration.between(inicio, fin);
                String duracionFormato = String.format("%02d:%02d:%02d", 
                    duracion.toHours(), 
                    duracion.toMinutesPart(), 
                    duracion.toSecondsPart());

                // Determinar el resultado
                String resultado = partida.getPuntos() > 0 ? "Ganó" : "Perdió";

                // Escribir los datos de la partida
                writer.printf("%-20s %-10s %-20s %-10d %-10s%n",
                        inicio.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                        duracionFormato,
                        partida.getNombreJugador(),
                        partida.getPuntos(),
                        resultado);

                // Mensaje de depuración
                System.out.println("Partida exportada: " + partida.getNombreJugador() + " | Puntos: " + partida.getPuntos());
            }

            writer.close();
            System.out.println("Exportación de partidas completada correctamente.");

        } catch (IOException ioe) {
            System.out.println("Error al exportar las partidas: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado al exportar las partidas: " + e.getMessage());
        }
    }
}

}
