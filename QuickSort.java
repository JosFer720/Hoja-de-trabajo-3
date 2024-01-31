/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */

import java.lang.Comparable;

/**
 * Clase que implementa el algoritmo de ordenación QuickSort para un arreglo genérico.
 *
 * @param <T> el tipo de elementos en el arreglo que deben ser comparables entre sí.
 */
public class QuickSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena el arreglo utilizando el algoritmo QuickSort.
     *
     * @param arr el arreglo a ser ordenado.
     * @return el arreglo ordenado.
     */
    @Override
    public T[] sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * Realiza la clasificación rápida del arreglo.
     *
     * @param arr  el arreglo a ser ordenado.
     * @param low  el índice más bajo del rango actual.
     * @param high el índice más alto del rango actual.
     */
    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Particiona el arreglo en dos partes y devuelve el índice del pivote.
     *
     * @param arr  el arreglo a ser ordenado.
     * @param low  el índice más bajo del rango actual.
     * @param high el índice más alto del rango actual.
     * @return el índice del pivote.
     */
    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Intercambia dos elementos en el arreglo.
     *
     * @param arr el arreglo en el que se realizará el intercambio.
     * @param i   el índice del primer elemento.
     * @param j   el índice del segundo elemento.
     */
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}