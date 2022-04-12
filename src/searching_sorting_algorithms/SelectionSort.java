package searching_sorting_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author helena81
 * @version 1.0
 * @since 12.04.22
 */
public class SelectionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        sortArray(array);

        for (int element : array) {
            System.out.print(element + " ");
        }
    }

    private static void sortArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minElementIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minElementIndex] > array[j]) {
                    minElementIndex = j;
                }
            }

            swap(array, minElementIndex, i);
        }
    }

    private static void swap(int[] array, int minElementIndex, int index) {
        int element = array[index];
        array[index] = array[minElementIndex];
        array[minElementIndex] = element;
    }
}
