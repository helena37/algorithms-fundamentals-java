package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author helena81
 * @version 1.0
 * @since 7.04.22
 */
public class Combination {
    public static String[] elements;
    public static String[] combinations;

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        elements = reader.readLine().split("\\s+");
        int k = Integer.parseInt(reader.readLine());

        combinations = new String[k];

        combine(0, 0);

    }

    private static void combine(int index, int start) {
        if (index == combinations.length) {
            print(combinations);
        } else {
            for (int i = start; i < elements.length; i++) {

                combinations[index] = elements[i];
                combine(index + 1, i + 1);
            }
        }
    }

    private static void print(String[] combinations) {
        System.out.println(String.join(" ", combinations));
    }
}
