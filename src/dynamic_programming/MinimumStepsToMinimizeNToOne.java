package dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author helena81
 * @version 1.0
 * @since 16.04.22
 */
public class MinimumStepsToMinimizeNToOne {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please, enter a value:");
        int n = Integer.parseInt(reader.readLine());

        System.out.println(getMinimumStepsTab(n));
    }

    //Tabulation
    public static int getMinimumStepsTab(int n) {
        int[] table = new int[n + 1];
        Arrays.fill(table, n);

        table[1] = 0;

        for (int i = 1; i < n; i++) {
            table[i + 1] = Math.min(table[i + 1], table[i] + 1);
            if (i * 2 <= n) {
                table[i * 2] = Math.min(table[i] + 1, table[i * 2]);
            }
            if (i * 3 <= n) {
                table[i * 3] = Math.min(table[i] + 1, table[i * 3]);
            }
        }

        return table[n];
    }

    //Recursion with memoization
    //Dynamic programming
    public static int getMinimumStepsMemo(int n, int[] memo) {
        if (n == 1) {
            return 0;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        int result = getMinimumStepsMemo(n - 1, memo);

        if (n % 2 == 0) {
            result = Math.min(result, getMinimumStepsMemo(n / 2, memo));
        }

        if (n % 3 == 0) {
            result = Math.min(result, getMinimumStepsMemo(n / 3, memo));
        }

        memo[n] = result + 1;
        return memo[n];
    }

    //Recursion without memoization
    //Dynamic programming
    public static int getMinimumSteps(int n) {
        if (n == 1) {
            return 0;
        }

        int result = getMinimumSteps(n - 1);

        if (n % 2 == 0) {
            result = Math.min(result, getMinimumSteps(n / 2));
        }

        if (n % 3 == 0) {
            result = Math.min(result, getMinimumSteps(n / 3));
        }

        return result + 1;
    }
}
