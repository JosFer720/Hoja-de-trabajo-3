/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */

import java.util.Arrays;

/**
 * Clase que implementa el algoritmo de ordenación Radix Sort para un arreglo genérico.
 *
 * @param <T> el tipo de elementos en el arreglo que deben ser comparables entre sí.
 */
public class RadixSort<T extends Comparable<T>> implements IGenericSort<T> {

    /**
     * Ordena el arreglo utilizando el algoritmo Radix Sort.
     *
     * @param arr el arreglo a ser ordenado.
     * @return el arreglo ordenado.
     */
    @Override
    public T[] sort(T[] arr) {
        int maxLength = getMaxLength(arr);
        radixSort(arr, maxLength);
        return arr;
    }

    /**
     * Obtiene la longitud máxima de los elementos en el arreglo.
     *
     * @param arr el arreglo del cual se obtendrá la longitud máxima.
     * @return la longitud máxima.
     */
    private int getMaxLength(T[] arr) {
        int maxLength = 0;

        for (T num : arr) {
            int length = num.toString().length();
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    /**
     * Realiza el ordenamiento Radix Sort en el arreglo.
     *
     * @param arr      el arreglo a ser ordenado.
     * @param maxLength la longitud máxima de los elementos en el arreglo.
     */
    private void radixSort(T[] arr, int maxLength) {
        int n = arr.length;
        int divisor = 1;

        while (maxLength-- > 0) {
            int[] count = new int[10];
            T[] output = Arrays.copyOf(arr, n);

            for (int i = 0; i < n; i++) {
                int digit = getDigit(arr[i], divisor);
                count[digit]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            for (int i = n - 1; i >= 0; i--) {
                int digit = getDigit(arr[i], divisor);
                output[count[digit] - 1] = arr[i];
                count[digit]--;
            }

            System.arraycopy(output, 0, arr, 0, n);
            divisor *= 10;
        }
    }

    /**
     * Obtiene el dígito en la posición específica de un número.
     *
     * @param num     el número del cual se obtendrá el dígito.
     * @param divisor el divisor para obtener el dígito en la posición específica.
     * @return el dígito en la posición específica.
     */
    private int getDigit(T num, int divisor) {
        return (num.hashCode() / divisor) % 10;
    }
}