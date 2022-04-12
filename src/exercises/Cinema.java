package exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author helena81
 * @version 1.0
 * @since 9.04.22
 */
public class Cinema {
    public static String[] seats;
    public static String[] combinations;
    public static boolean[] used;
    public static List<String> friends;

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        friends = Arrays.stream(reader.readLine().split(", "))
                .collect(Collectors.toList());

        seats = new String[friends.size()];

        String line = reader.readLine();

        while (!line.equals("generate")) {
            String[] tokens = line.split(" - ");
            String name = tokens[0];
            int place = Integer.parseInt(tokens[1]) - 1;

            seats[place] = name;

            friends.remove(name);

            line = reader.readLine();
        }

        combinations = new String[friends.size()];
        used = new boolean[friends.size()];

        permute(0);
    }

    private static void permute(int index) {
        if (index == combinations.length) {
            print();
        } else {
            for (int i = 0; i < friends.size(); i++) {
                if (!used[i]) {
                    used[i] = true;
                    combinations[index] = friends.get(i);
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;

        for (String seat : seats) {
            if (seat != null) {
                System.out.print(seat + " ");
            } else {
                System.out.print(combinations[index] + " ");
                index++;
            }
        }
        System.out.println();
    }
}
