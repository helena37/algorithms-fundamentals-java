package recursion;

import java.util.Scanner;

/**
 * @author helena81
 * @version 1.0
 * @since 23.03.22
 */
public class GeneratingVectors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        Integer[] memory = new Integer[input];

        fillVector(memory, 0);
    }

    private static void fillVector(Integer[] memory, int memoryLength) {
        if (memoryLength >= memory.length) {
            print(memory);
            return;
        }

        for (int i = 0; i <= 1; i++) {
            memory[memoryLength] = i;
            fillVector(memory, memoryLength + 1);
        }
    }

    private static void print(Integer[] memory) {
        for (Integer integer : memory) {
            System.out.print(integer);
        }
        System.out.println();
    }
}
