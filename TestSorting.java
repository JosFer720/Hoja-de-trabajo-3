import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class TestSorting {

    @Test
    public void testMergeSort() {
        Integer[] arr = {5, 2, 9, 1, 5, 6};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] result = mergeSort.sort(arr);
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testQuickSort() {
        String[] arr = {"banana", "apple", "orange", "grape"};
        QuickSort<String> quickSort = new QuickSort<>();
        String[] result = quickSort.sort(arr);
        String[] expected = {"apple", "banana", "grape", "orange"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRadixSort() {
        Integer[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        RadixSort<Integer> radixSort = new RadixSort<>();
        Integer[] result = radixSort.sort(arr);
        Integer[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testInsertionSort() {
        Double[] arr = {3.5, 1.2, 4.8, 2.1, 5.7};
        InsertionSort<Double> insertionSort = new InsertionSort<>();
        Double[] result = insertionSort.sort(arr);
        Double[] expected = {1.2, 2.1, 3.5, 4.8, 5.7};
        assertArrayEquals(expected, result);
    }

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