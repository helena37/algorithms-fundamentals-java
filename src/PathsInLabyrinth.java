import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PathsInLabyrinth {
    static List<Character> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] labyrinth = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            labyrinth[row] = reader.readLine().toCharArray();
        }

        findPath(labyrinth, 0, 0, labyrinth[0][0]);
    }

    private static void findPath(char[][] labyrinth, int row, int col, char direction) {
        if (!isInBounds(labyrinth, row, col)
                || labyrinth[row][col] == 'V'
                || labyrinth[row][col] == '*') {
            return;
        }

        path.add(direction);

        if (labyrinth[row][col] == 'e') {
            printPath();
            return;
        }

        labyrinth[row][col] = 'V';

        findPath(labyrinth, row - 1, col, 'U');
        findPath(labyrinth, row + 1, col, 'D');
        findPath(labyrinth, row, col - 1, 'L');
        findPath(labyrinth, row, col + 1, 'R');

        labyrinth[row][col] = '-';

        path.remove(path.size() - 1);
    }

    private static void printPath() {
        path.remove(0);
        for (Character character : path) {
            System.out.print(character);
        }

        System.out.println();
    }

    private static boolean isInBounds(char[][] labyrinth, int row, int col) {
        return row < labyrinth.length && row >= 0
                && col < labyrinth[row].length && col >= 0;
    }
}
