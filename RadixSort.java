import java.util.Arrays;

public class RadixSort<T extends Comparable<T>> implements IGenericSort<T> {

    @Override
    public T[] sort(T[] arr) {
        int maxLength = getMaxLength(arr);
        radixSort(arr, maxLength);
        return arr;
    }

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

    private int getDigit(T num, int divisor) {
        return (num.hashCode() / divisor) % 10;
    }
}
