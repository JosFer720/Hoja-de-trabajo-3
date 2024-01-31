import java.lang.Comparable;

public class MergeSort<T extends Comparable<T>> implements IGenericSort<T> {

    @Override
    public T[] sort(T[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int n = arr.length;

        if (n <= 1) {
            return arr;
        }

        int middle = n / 2;
        T[] left = (T[]) new Comparable[middle];
        T[] right = (T[]) new Comparable[n - middle];

        System.arraycopy(arr, 0, left, 0, middle);
        System.arraycopy(arr, middle, right, 0, n - middle);

        sort(left);
        sort(right);

        merge(arr, left, right);

        return arr;
    }

    private void merge(T[] arr, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}