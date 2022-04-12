package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author helena81
 * @version 1.0
 * @since 8.04.22
 */
public class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        reverseArray(array, 0, array.length - 1);
    }

    private static void reverseArray(int[] array, int start, int end) {
        if (start >= end) {
            print(array);
            return;
        }

        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        reverseArray(array, start + 1, end - 1);
    }

    private static void print(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
