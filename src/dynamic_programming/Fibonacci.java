package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author helena81
 * @version 1.0
 * @since 16.04.22
 */
public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, enter the key number:");
        int n = Integer.parseInt(reader.readLine());

        System.out.println(getFibonacci(n));
    }

    private static int getFibonacci(int n) {
        int[] memo = new int[n + 1];

        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        memo[n] = getFibonacci(n - 1) + getFibonacci(n - 2);

        return memo[n];
    }
}
