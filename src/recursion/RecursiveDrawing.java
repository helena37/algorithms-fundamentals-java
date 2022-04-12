package recursion;

import java.util.Scanner;

/**
 * @author helena81
 * @version 1.0
 * @since 23.03.22
 */
public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        drawFigure(n);
    }

    private static void drawFigure(int n) {
        if (n == 0) {
            return;
        }
        drawingStrings(n, "*");

        drawFigure(n - 1);

        drawingStrings(n, "#");
    }

    private static void drawingStrings(int n, String s) {
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
        System.out.println();
    }
}
