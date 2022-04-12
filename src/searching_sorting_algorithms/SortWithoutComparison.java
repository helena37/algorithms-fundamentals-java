package searching_sorting_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @author helena81
 * @version 1.0
 * @since 12.04.22
 */
public class SortWithoutComparison {
    public static int[] counts;
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        int[] arr =
                Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        IntStream intStream = Arrays.stream(arr);
        OptionalInt optionalInt = intStream.max();
        int maxSize = optionalInt.getAsInt();

        counts = new int[maxSize + 1];

        sortWithoutComparison(arr);
        printSortedArr(counts);
    }

    private static void printSortedArr(int[] arr) {
        for (int index = 0; index < counts.length; index++) {
            if (counts[index] != 0) {
                for (int i = 0; i < counts[index]; i++) {
                    System.out.print(index + " ");
                }
            }
        }
    }

    private static void sortWithoutComparison(int[] arr) {
        for (int element : arr) {
            counts[element]++;
        }
    }
}
