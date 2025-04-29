package utilidades;

    import java.io.*;
    import java.util.Scanner;
    
    
    public class Utilidades {
    
        private static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    
        public static String leerCadenaValida(String mensaje) throws IOException {
            System.out.println(mensaje);
            return buffer.readLine();
        }
    
        
        public static String leerCadenaTexto(Scanner scanner, String mensaje) {
        String entrada;
        boolean esValida = false;

        do {
            System.out.println(mensaje);
            entrada = scanner.nextLine();
            if (entrada.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                esValida = true;
            } else {
                System.out.println("Entrada no válida. Por favor, introduce solo letras.");
            }
        } while (!esValida);

        return entrada;
        }
    
    
        public static int leerNumero(Scanner scanner, String mensaje) {
            int numero = -1;
            boolean esValido = false;

            do {
                try {
                    System.out.println(mensaje);
                    numero = Integer.parseInt(scanner.nextLine());
                    if (numero > 0) { 
                        esValido = true;
                    } else {
                        System.out.println("Por favor, introduce un número válido mayor a 0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, introduce solo números.");
                }
            } while (!esValido);

            return numero;
        }
    
        public static int leerNumeroEntreSinLetra(int numeroMin, int numeroMax)throws IOException{
            int numeroDevolver = 0;
            boolean numeroCorrecto = false;
    
            do {
                try {
                    numeroDevolver = Integer.parseInt(buffer.readLine());
                    if (numeroDevolver >= numeroMin && numeroDevolver <= numeroMax) {
                        numeroCorrecto = true;
                    } else {
                        System.out.println("Por favor escriba un numero entre " + numeroMin + " y " + numeroMax + " incluidos");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Opción no válida. Escriba un numero por favor.");
                }
    
            } while (!numeroCorrecto);
    
            return numeroDevolver;
        }
    
}