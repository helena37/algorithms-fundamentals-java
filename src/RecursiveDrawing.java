import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveDrawing {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int n = Integer.parseInt(reader.readLine());

        drawFigure(n);

    }

    private static void drawFigure(int n) {

        if (n == 0) {
            return;
        }

        draw(n,'*');

        drawFigure(n - 1);

        draw(n, '#');
    }

    private static void draw(int n, char symbol) {
        for (int i = 1; i <= n; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }
}
