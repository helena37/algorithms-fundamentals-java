package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

/**
 * @author helena81
 * @version 1.0
 * @since 8.04.22
 */
public class TowerOfHanoi {
    public static StringBuilder out = new StringBuilder();
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static int steps = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int disk = Integer.parseInt(reader.readLine());

        for (int i = disk; i >= 1; i--) {
            source.push(i);
        }

        printRods();
        solvePuzzle(disk, source, destination, spare);

        System.out.println(out.toString());
    }

    private static void solvePuzzle(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            out.append("Step #")
                    .append(steps++)
                    .append(": Moved disk")
                    .append(System.lineSeparator());
            printRods();
        } else {
            solvePuzzle(disk - 1, source, spare, destination);
            solvePuzzle(1, source, destination, spare);
            solvePuzzle(disk - 1, spare, destination, source);
        }
    }

    public static void printRods() {
        out.append(String.format("Source: %s%n" +
                "Destination: %s%n" +
                "Spare: %s%n", formatRod(source), formatRod(destination), formatRod(spare)))
                .append(System.lineSeparator());
    }

    private static String formatRod(Deque<Integer> stack) {
        return stack.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
