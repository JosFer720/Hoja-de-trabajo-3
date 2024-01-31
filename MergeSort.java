/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */

import java.util.Arrays;

/**
 * Clase que implementa el algoritmo de ordenación Merge Sort para un arreglo genérico.
 *
 * @param <T> el tipo de elementos en el arreglo que deben ser comparables entre sí.
 */
public class MergeSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena el arreglo utilizando el algoritmo Merge Sort.
     *
     * @param arr el arreglo a ser ordenado.
     * @return el arreglo ordenado.
     */
    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * Realiza el proceso de dividir y combinar para ordenar el arreglo.
     *
     * @param arr    el arreglo a ser ordenado.
     * @param inicio el índice de inicio del rango actual.
     * @param fin    el índice de fin del rango actual.
     */
    private void mergeSort(T[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            mergeSort(arr, inicio, medio);
            mergeSort(arr, medio + 1, fin);

            merge(arr, inicio, medio, fin);
        }
    }

    /**
     * Combina dos subarreglos ordenados en un solo arreglo ordenado.
     *
     * @param arr    el arreglo a ser ordenado.
     * @param inicio el índice de inicio del primer subarreglo.
     * @param medio  el índice de fin del primer subarreglo y comienzo del segundo subarreglo.
     * @param fin    el índice de fin del segundo subarreglo.
     */
    private void merge(T[] arr, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        T[] izquierda = Arrays.copyOfRange(arr, inicio, inicio + n1);
        T[] derecha = Arrays.copyOfRange(arr, medio + 1, medio + 1 + n2);

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (izquierda[i].compareTo(derecha[j]) <= 0) {
                arr[k++] = izquierda[i++];
            } else {
                arr[k++] = derecha[j++];
            }
        }

        while (i < n1) {
            arr[k++] = izquierda[i++];
        }

        while (j < n2) {
            arr[k++] = derecha[j++];
        }
    }
}