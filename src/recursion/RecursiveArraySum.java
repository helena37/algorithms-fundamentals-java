package recursion;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author helena81
 * @version 1.0
 * @since 22.03.22
 */
public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;

        //iterative approach
        for (int num : arr) {
            sum += num;
        }

        System.out.println("Iterative approach: " + sum);

        //recursive approach
        sum = sumNumbers(arr, 0);
        System.out.println("Recursive approach: " + sum);
    }

    private static int sumNumbers(int[] numbers, int index) {
        if (index >= numbers.length) {
            return 0;
        }
        return numbers[index] + sumNumbers(numbers, index + 1);
    }
}
