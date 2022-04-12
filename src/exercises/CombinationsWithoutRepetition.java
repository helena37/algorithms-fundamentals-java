package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author helena81
 * @version 1.0
 * @since 8.04.22
 */
public class CombinationsWithoutRepetition {
    public static int[] input;
    public static int[] combinations;

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());

        input = new int[n];
        combinations = new int[k];

        for (int i = 0; i < n; i++) {
            input[i] = i + 1;
        }

        combine(0, 0);
    }

    private static void combine(int index, int start) {
        if (index == combinations.length) {
            print(combinations);
            return;
        }

        for (int i = start; i < input.length; i++) {
            combinations[index] = input[i];
            combine(index + 1, i + 1);
        }

    }

    private static void print(int[] combinations) {
        for (int combination : combinations) {
            System.out.print(combination + " ");
        }

        System.out.println();
    }
}
