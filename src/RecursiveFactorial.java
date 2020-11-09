import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int n = Integer.parseInt(reader.readLine());

        System.out.println(calculateFactorial(n));
    }

    private static long calculateFactorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }
}
