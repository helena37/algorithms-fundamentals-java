package searching_sorting_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author helena81
 * @version 1.0
 * @since 12.04.22
 */
public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int key = Integer.parseInt(reader.readLine());

        if (findIndex(array, key) >= 0) {
            System.out.println("Index of " + key + " is " + findIndex(array, key));
        } else {
            System.out.println("Element doesn't exist in the array.");
        }
    }

    private static int findIndex(int[] arr, int key) {
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] == key) {
                return mid;
            } else {
                end = mid - 1;
            }

            mid = (start + end) / 2;
        }

        return -1;
    }
}
