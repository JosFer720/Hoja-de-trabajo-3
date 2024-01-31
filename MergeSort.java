import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements IGenericSort<T> {

    @Override
    public T[] sort(T[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }

        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void mergeSort(T[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            mergeSort(arr, inicio, medio);
            mergeSort(arr, medio + 1, fin);

            merge(arr, inicio, medio, fin);
        }
    }

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
