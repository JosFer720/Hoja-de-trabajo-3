/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal que contiene un programa para generar, guardar, leer y mostrar números en archivos ordenarYMostrar.
*/
public class Principal {

    /**
     * Punto de entrada principal para ejecutar el programa.
    *
    * @param args Los argumentos de la línea de comandos (no utilizados en este programa).
    */
    public static void main(String[] args) {
        mostrarMenu();
    }

    /**
     * Muestra el menú principal y maneja las opciones del usuario.
    */
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Generar y guardar números en archivo");
            System.out.println("2. Leer y ordenar datos");
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
                    System.out.println("Los resultados se han guardado en la carpeta 'resultados' en la misma ubicación del archivo.");
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

    /**
     * Genera números aleatorios y los guarda en un archivo ordenarYMostrar.
    *
    * @param nombreArchivoordenarYMostrar El nombre del archivo ordenarYMostrar en el que se guardarán los números generados.
    */
    public static void generarYGuardar(String nombreArchivoordenarYMostrar) {
        final int LIMITE_NUMEROS = 3000;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivoordenarYMostrar))) {
            Random rand = new Random();

            for (int i = 0; i < LIMITE_NUMEROS; i++) {
                int numero = rand.nextInt();
                writer.write(Integer.toString(numero));
                writer.write(",");
                writer.newLine();
            }

            System.out.println("Se generaron y guardaron " + LIMITE_NUMEROS + " números en el archivo " + nombreArchivoordenarYMostrar);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee números desde un archivo ordenarYMostrar, los muestra en la consola y realiza ordenaciones con diferentes cantidades de números.
    *
    * @param nombreArchivoordenarYMostrar El nombre del archivo ordenarYMostrar desde el cual se leerán los números.
    */
    public static void leerYMostrarNumeros(String nombreArchivoordenarYMostrar) {
        List<Integer> numeros = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivoordenarYMostrar))) {
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

            System.out.println("\nSe leyeron y mostraron los números del archivo " + nombreArchivoordenarYMostrar);

            ordenarYMostrar(numeros);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Realiza ordenaciones y muestra resultados con diferentes cantidades de números utilizando varios algoritmos de ordenación.
    *
    * @param numeros La lista de números a ordenar y mostrar.
    */
    private static void ordenarYMostrar(List<Integer> numeros) {
        List<Integer> cantidades = Arrays.asList(10, 100, 500, 1000, 1200, 1600, 1800, 2000, 3000);

        for (Integer cantidad : cantidades) {
            System.out.println("\nOrdenando " + cantidad + " números:");

            List<Integer> subLista = numeros.subList(0, Math.min(cantidad, numeros.size()));
            Integer[] arr = subLista.toArray(new Integer[0]);

            System.out.println("Antes de la ordenación: " + Arrays.toString(arr));

            sorting(arr);

            System.out.println("Después de la ordenación: " + Arrays.toString(arr));
        }
    }

    /**
     * Realiza pruebas de algoritmos de ordenación y guarda los resultados en archivos.
    *
    * @param arr El arreglo de números a ordenar y probar con diferentes algoritmos de ordenación.
    */
    private static void sorting(Integer[] arr) {
        String directorioResultados = "resultados/";
        crearDirectorio(directorioResultados);
    
        guardarResultados("MergeSort", arr, new MergeSort<>(), directorioResultados);
        guardarResultados("QuickSort", arr, new QuickSort<>(), directorioResultados);
        guardarResultados("RadixSort", arr, new RadixSort<>(), directorioResultados);
        guardarResultados("InsertionSort", arr, new InsertionSort<>(), directorioResultados);
        guardarResultados("GnomeSort", arr, new GnomeSort<>(), directorioResultados);
    }
    
    /**
     * Guarda los resultados de un algoritmo de ordenación en un archivo.
    *
    * @param nombreAlgoritmo El nombre del algoritmo de ordenación.
    * @param arr El arreglo de números a ordenar y guardar.
    * @param algoritmo El objeto que implementa el algoritmo de ordenación.
    * @param directorio El directorio donde se guardarán los resultados.
    */
    private static void guardarResultados(String nombreAlgoritmo, Integer[] arr, IGenericSort<Integer> algoritmo, String directorio) {
        Integer[] resultado = algoritmo.sort(Arrays.copyOf(arr, arr.length));
        String nombreArchivo = directorio + nombreAlgoritmo + "_" + arr.length + ".txt";
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Integer numero : resultado) {
                writer.write(numero.toString());
                writer.write(",");
                writer.newLine();
            }
    
            System.out.println("Resultado de " + nombreAlgoritmo + " para " + arr.length + " números guardado en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    /**
     * Crea un directorio si no existe.
    *
    * @param directorio El directorio a crear.
    */
    private static void crearDirectorio(String directorio) {
        try {
            new File(directorio).mkdirs();
        } catch (Exception e) {
            System.err.println("Error al crear el directorio: " + e.getMessage());
        }
    }
}