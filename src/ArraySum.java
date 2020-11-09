import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        System.out.println("Please enter numbers: ");

       int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
               .mapToInt(Integer::parseInt)
               .toArray();

        int sumTwo = sumNumbers(arr, 0);

        System.out.println("Recursion sum: " + sumTwo);
    }

    private static int sumNumbers(int[] arr, int index) {

        if (index >= arr.length) {
            return 0;
        }

       return arr[index] + sumNumbers(arr, index + 1);
    }
}
