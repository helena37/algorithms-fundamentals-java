package recursion;

import java.util.Scanner;

/**
 * @author helena81
 * @version 1.0
 * @since 23.03.22
 */
public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //iterative approach
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        System.out.println(calculateFactorial(n));
    }

    //recursive approach
    private static long calculateFactorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
