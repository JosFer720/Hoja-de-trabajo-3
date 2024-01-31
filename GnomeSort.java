/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */

import java.lang.Comparable;

/**
 * Clase que implementa el algoritmo de ordenación Gnome Sort para un arreglo genérico.
 *
 * @param <T> el tipo de elementos en el arreglo que deben ser comparables entre sí.
 */
public class GnomeSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena el arreglo utilizando el algoritmo Gnome Sort.
     *
     * @param arr el arreglo a ser ordenado.
     * @return el arreglo ordenado.
     */
    @Override
    public T[] sort(T[] arr) {
        int n = arr.length;
        int index = 0;

        while (index < n) {
            if (index == 0 || arr[index - 1].compareTo(arr[index]) <= 0) {
                index++;
            } else {
                swap(arr, index, index - 1);
                index--;
            }
        }

        return arr;
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