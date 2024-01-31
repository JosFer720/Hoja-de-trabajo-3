import java.lang.Comparable;

public class GnomeSort <T extends Comparable<T>> implements IGenericSort<T> {

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

    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}