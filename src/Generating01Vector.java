import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Generating01Vector {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int n = Integer.parseInt(reader.readLine());

        Integer[] memory = new Integer[n];

        fillVector(memory, 0);

    }

    private static void fillVector(Integer[] memory, int length) {
        if (length >= memory.length) {
            printVector(memory);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            memory[length] = i;
            fillVector(memory, length + 1);
        }
    }

    private static void printVector(Integer[] memory) {
        for (Integer integer : memory) {
            System.out.print(integer);
        }

        System.out.println();
    }
}
