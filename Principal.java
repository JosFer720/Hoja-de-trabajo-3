import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
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
            System.out.println("1. Generar y guardar números archivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número válido.");
                scanner.nextLine();
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del archivo: ");
                    String nombreArchivoCSV = scanner.nextLine();
                    generarYGuardar(nombreArchivoCSV);
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
}