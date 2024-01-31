/**
 * Fernando Ruiz 23065
 * Erick Guerra 23208
 * ALGORITMOS Y ESTRUCTURAS DE DATOS 2016
 */

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 * Clase de pruebas para los algoritmos de ordenación.
 */
public class TestSorting {

    /**
     * Prueba para el algoritmo Merge Sort con arreglo de enteros.
     */
    @Test
    public void testMergeSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] result = mergeSort.sort(arr);
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, result);
    }

    /**
     * Prueba para el algoritmo Quick Sort con arreglo de cadenas.
     */
    @Test
    public void testQuickSort() {
        String[] arr = {"banana", "apple", "orange", "grape"};
        QuickSort<String> quickSort = new QuickSort<>();
        String[] result = quickSort.sort(arr);
        String[] expected = {"apple", "banana", "grape", "orange"};
        assertArrayEquals(expected, result);
    }

    /**
     * Prueba para el algoritmo Radix Sort con arreglo de enteros.
     */
    @Test
    public void testRadixSort() {
        Integer[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort<Integer> radixSort = new RadixSort<>();
        Integer[] result = radixSort.sort(arr);
        Integer[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        assertArrayEquals(expected, result);
    }

    /**
     * Prueba para el algoritmo Insertion Sort con arreglo de números decimales.
     */
    @Test
    public void testInsertionSort() {
        Double[] arr = {3.5, 1.2, 4.8, 2.1, 5.7};
        InsertionSort<Double> insertionSort = new InsertionSort<>();
        Double[] result = insertionSort.sort(arr);
        Double[] expected = {1.2, 2.1, 3.5, 4.8, 5.7};
        assertArrayEquals(expected, result);
    }

    /**
     * Prueba para el algoritmo Gnome Sort con un arreglo que se espera falle.
     */
    @Test
    public void testGnomeSortFailure() {
        // Cambié el orden del arreglo para que la prueba falle
        Character[] arr = {'g', 'n', 'm', 'o', 'e'};
        GnomeSort<Character> gnomeSort = new GnomeSort<>();
        Character[] result = gnomeSort.sort(arr);
        Character[] expected = {'g', 'e', 'm', 'n', 'o'};
        assertArrayEquals(expected, result);
    }
}