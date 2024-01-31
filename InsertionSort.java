/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */

import java.lang.Comparable;

/**
 * Clase que implementa el algoritmo de ordenación Insertion Sort para un arreglo genérico.
 *
 * @param <T> el tipo de elementos en el arreglo que deben ser comparables entre sí.
 */
public class InsertionSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena el arreglo utilizando el algoritmo Insertion Sort.
     *
     * @param arr el arreglo a ser ordenado.
     * @return el arreglo ordenado.
     * @throws IllegalArgumentException si el arreglo de entrada es nulo.
     */
    @Override
    public T[] sort(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }

        return arr;
    }
}