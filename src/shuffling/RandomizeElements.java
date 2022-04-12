package shuffling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author helena81
 * @version 1.0
 * @since 12.04.22
 */
public class RandomizeElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);
        getAsRandom(arr);


        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void getAsRandom(int[] arr) {
        int[] result = new int[arr.length];
        ThreadLocalRandom localRandom = ThreadLocalRandom.current();

        for (int i = 0; i < arr.length; i++) {
            swapElements(arr, i, localRandom.nextInt(arr.length));
        }
    }

    private static void swapElements(int[] arr, int i, int nextInt) {
        int temp = arr[i];
        arr[i] = arr[nextInt];
        arr[nextInt] = temp;
    }
}
