package utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase de utilidades para leer datos desde consola usando BufferedReader.
 * 
 * @version Final
 * @date 24/04/2025
 */
public class Leer {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Lee una cadena de texto desde consola.
     * 
     * @param mensaje Mensaje que se mostrará al usuario.
     * @return Cadena ingresada por el usuario.
     */
    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer texto. Intenta nuevamente.");
            return leerString(mensaje);
        }
    }

    /**
     * Lee un número entero desde consola.
     * 
     * @param mensaje Mensaje que se mostrará al usuario.
     * @return Número entero ingresado por el usuario.
     */
    public static int leerInt(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Valor inválido. Introduce un número entero.");
            return leerInt(mensaje);
        }
    }

    /**
     * Lee un número entero dentro de un rango específico (inclusive).
     * 
     * @param mensaje Mensaje que se mostrará al usuario.
     * @param minimo  Valor mínimo aceptado.
     * @param maximo  Valor máximo aceptado.
     * @return Número entero dentro del rango.
     */
    public static int leerIntEntre(String mensaje, int minimo, int maximo) {
        int valor = leerInt(mensaje);
        if (valor < minimo || valor > maximo) {
            System.out.println("Por favor, elige una opción entre " + minimo + " y " + maximo + ".");
            return leerIntEntre(mensaje, minimo, maximo);
        }
        return valor;
    }

    /**
     * Lee un número decimal (double) desde consola.
     * 
     * @param mensaje Mensaje que se mostrará al usuario.
     * @return Número decimal ingresado por el usuario.
     */
    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        try {
            return Double.parseDouble(reader.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Valor inválido. Introduce un número decimal.");
            return leerDouble(mensaje);
        }
    }

    /**
     * Lee un valor booleano desde consola.
     * 
     * @param mensaje Mensaje que se mostrará al usuario.
     * @return true si el usuario escribe "true" (ignorando mayúsculas/minúsculas),
     *         false si escribe "false".
     */
    public static boolean leerBoolean(String mensaje) {
        System.out.print(mensaje + " (true/false): ");
        try {
            return Boolean.parseBoolean(reader.readLine().trim());
        } catch (IOException e) {
            System.out.println("Error al leer el valor. Intenta nuevamente.");
            return leerBoolean(mensaje);
        }
    }
}