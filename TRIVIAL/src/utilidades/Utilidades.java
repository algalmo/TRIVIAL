package utilidades;

import java.io.*;
import java.util.Scanner;

/**
 * Clase de utilidades para manejar entradas del usuario en el videojuego Trivial.
 * 
 * @version Final
 * @date 29/04/2025
 */
public class Utilidades {

    private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Lee una cadena válida desde consola.
     * 
     * @param mensaje Mensaje que se mostrará al jugador.
     * @return Cadena ingresada por el jugador.
     * @throws IOException Si ocurre un error al leer la entrada.
     */
    public static String leerCadenaValida(String mensaje) throws IOException {
        System.out.println(mensaje);
        return buffer.readLine().trim();
    }

    /**
     * Lee una cadena de texto que solo contenga letras y espacios.
     * 
     * @param scanner Scanner para leer la entrada.
     * @param mensaje Mensaje que se mostrará al jugador.
     * @return Cadena válida ingresada por el jugador.
     */
    public static String leerCadenaTexto(Scanner scanner, String mensaje) {
        String entrada;
        boolean esValida = false;

        do {
            System.out.println(mensaje);
            entrada = scanner.nextLine().trim();
            if (entrada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                esValida = true;
            } else {
                System.out.println("⚠️ Entrada no válida. Por favor, introduce solo letras.");
            }
        } while (!esValida);

        return entrada;
    }

    /**
     * Lee un número entero válido desde consola.
     * 
     * @param scanner Scanner para leer la entrada.
     * @param mensaje Mensaje que se mostrará al jugador.
     * @return Número entero ingresado por el jugador.
     */
    public static int leerNumero(Scanner scanner, String mensaje) {
        int numero = -1;
        boolean esValido = false;

        do {
            try {
                System.out.println(mensaje);
                numero = Integer.parseInt(scanner.nextLine().trim());
                if (numero >= 0) { // Permitir números positivos o cero
                    esValido = true;
                } else {
                    System.out.println("⚠️ Por favor, introduce un número válido mayor o igual a 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada no válida. Por favor, introduce solo números.");
            }
        } while (!esValido);

        return numero;
    }

    /**
     * Lee un número entero dentro de un rango específico.
     * 
     * @param numeroMin Valor mínimo aceptado.
     * @param numeroMax Valor máximo aceptado.
     * @return Número entero dentro del rango.
     * @throws IOException Si ocurre un error al leer la entrada.
     */
    public static int leerNumeroEntre(int numeroMin, int numeroMax) throws IOException {
        int numeroDevolver = 0;
        boolean numeroCorrecto = false;

        do {
            try {
                System.out.println("Introduce un número entre " + numeroMin + " y " + numeroMax + ":");
                numeroDevolver = Integer.parseInt(buffer.readLine().trim());
                if (numeroDevolver >= numeroMin && numeroDevolver <= numeroMax) {
                    numeroCorrecto = true;
                } else {
                    System.out.println("⚠️ Por favor, escribe un número entre " + numeroMin + " y " + numeroMax + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada no válida. Escribe un número por favor.");
            }
        } while (!numeroCorrecto);

        return numeroDevolver;
    }

    /**
     * Pausa el juego hasta que el jugador presione Enter.
     * 
     * @param mensaje Mensaje que se mostrará al jugador.
     */
    public static void pausar(String mensaje) {
        System.out.print(mensaje + " (Presiona Enter para continuar...)");
        try {
            buffer.readLine();
        } catch (IOException e) {
            System.out.println("⚠️ Error al pausar. Intenta nuevamente.");
        }
    }
}