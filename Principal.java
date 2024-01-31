import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Generar y guardar números en archivo");
            System.out.println("2. Leer y mostrar números de archivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Ingrese un número válido.");
                scanner.nextLine();
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del archivo: ");
                    String nombreArchivoGenerar = scanner.nextLine();
                    generarYGuardar(nombreArchivoGenerar);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del archivo a leer: ");
                    String nombreArchivoLeer = scanner.nextLine();
                    leerYMostrarNumeros(nombreArchivoLeer);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    public static void generarYGuardar(String nombreArchivoCSV) {
        final int LIMITE_NUMEROS = 3000;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoCSV))) {
            Random rand = new Random();

            for (int i = 0; i < LIMITE_NUMEROS; i++) {
                int numero = rand.nextInt();
                writer.write(Integer.toString(numero));
                writer.write(",");
                writer.newLine();
            }

            System.out.println("Se generaron y guardaron " + LIMITE_NUMEROS + " números en el archivo " + nombreArchivoCSV);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerYMostrarNumeros(String nombreArchivoCSV) {
        List<Integer> numeros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivoCSV))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] numerosEnTexto = linea.split(",");
                for (String numeroTexto : numerosEnTexto) {
                    try {
                        int numero = Integer.parseInt(numeroTexto);
                        numeros.add(numero);
                        System.out.print(numero + " ");
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir texto a número: " + e.getMessage());
                    }
                }
            }

            System.out.println("\nSe leyeron y mostraron los números del archivo " + nombreArchivoCSV);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}