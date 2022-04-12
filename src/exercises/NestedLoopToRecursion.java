package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author helena81
 * @version 1.0
 * @since 5.04.22
 */
public class NestedLoopToRecursion {
    public static int[] arr;
    public static int[] combinations;

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.parseInt(reader.readLine());
        arr = new int[limit];
        combinations = new int[limit];

        for (int i = 0; i < limit ; i++) {
            arr[i] = i + 1;
        }

            nestedLoopsToRecursion(0);
    }

    private static void nestedLoopsToRecursion(int index) {
        if (index == arr.length) {
            print(combinations);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            combinations[index] = arr[i];
            nestedLoopsToRecursion(index + 1);
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
